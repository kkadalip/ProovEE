package proov.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnitUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void msToKmh() {
		assertEquals("100m/s to 360km/h", UnitUtil.msToKmh(100d), new Double(360));
		assertEquals("36m/s to 129.6km/h exact", UnitUtil.msToKmh(36d), new Double(129.6));
		assertEquals("0m/ss to 0km/h exact", UnitUtil.msToKmh(0d), new Double(0));
		assertNull("null m/s to null", UnitUtil.msToKmh(null));
	}

	@Test
	public void kmhToMs() {
		assertEquals("1 kmh to 0.277778m/s", UnitUtil.kmhToMs((double) 1), new Double(0.2777777777777778));
		assertEquals("36 kmh to 10m/s", UnitUtil.kmhToMs((double) 36), new Double(10));
		assertEquals("0 kmh to 0m/s", UnitUtil.kmhToMs((double) 0), new Double(0));
	}

	@Test
	public void msToMph() {
		Double delta = 0.1;
		assertEquals("712m/s to 1592.7mph exact", UnitUtil.msToMph(712d), new Double(1592.7421860436214));
		assertEquals("712m/s to 1592.7mph with tolerance", 1592.7, UnitUtil.msToMph(712d), delta);
		assertEquals("-199m/s to -445.15mph with tolerance", -445.15, UnitUtil.msToMph(-199d), delta);
		assertNull("null m/s to null mph", UnitUtil.msToMph(null));
		assertNotNull("not null m/s to not null mph", UnitUtil.msToMph(123d));
	}

	@Test
	public void round() {
		assertEquals("Round to two places by default", UnitUtil.round(-17.77777777777778), new Double(-17.78));
		assertNull("Round null to X decimal places returns null", UnitUtil.round(null));
	}

	@Test
	public void round1() {
		assertEquals("Round to 3 decimal places", UnitUtil.round(-17.77777777777778, 3), new Double(-17.778));
		assertEquals("Round to 0 decimal places", UnitUtil.round(-17.77777777777778, 0), new Double(-18));
		assertEquals("Round to 1 decimal places", UnitUtil.round(-17.77777777777778, 1), new Double(-17.8));
		try {
			UnitUtil.round(-17.77777777777778, -1);
		} catch (IllegalArgumentException ex) {
			String expectedMessage = "Can not round to negative number of decimal places.";
			assertEquals("Exception message must be correct when rounding to negative decimal places", expectedMessage, ex.getMessage());
		}
		assertNull("Round null to X decimal places returns null", UnitUtil.round(null, 1));
	}

	@Test
	public void celsiusToFahrenheit() {
		Double delta = 0.001;
		assertEquals("56C -> 132.8F exact", UnitUtil.celsiusToFahrenheit((double) 56), new Double(132.8));
		assertEquals("-17.77777777777778C -> 0F exact", UnitUtil.celsiusToFahrenheit(-17.77777777777778), new Double(0));
		assertEquals("0C -> 32F exact", UnitUtil.celsiusToFahrenheit((double) 0), new Double(32));
		assertEquals("100C -> -148F", UnitUtil.celsiusToFahrenheit((double) -100), new Double(-148));
		assertEquals("0.7C -> 33.26F with tolerance", 33.26, UnitUtil.celsiusToFahrenheit(0.7), delta);
		assertEquals("0.7C -> 33.26F exact", UnitUtil.celsiusToFahrenheit(0.7), new Double(33.26));
	}

	@Test
	public void fahrenheitToCelsius() {
		Double delta = 0.001;
		assertEquals("32F -> 0C exact", UnitUtil.fahrenheitToCelsius(32d), new Double(0));
		assertEquals("0F -> -17.777...C exact", UnitUtil.fahrenheitToCelsius(0d), new Double(-17.77777777777778));
		assertEquals("132.8F -> 56C with tolerance", 56, UnitUtil.fahrenheitToCelsius(132.8), delta);
		assertEquals("-100F -> -73.3333C with tolerance", -73.3333, UnitUtil.fahrenheitToCelsius(-100d), delta);
		assertEquals("-100F -> -73.3333...C exact", UnitUtil.fahrenheitToCelsius(-100d), new Double(-73.33333333333334));
	}
}