package proov.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WindChillUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void calcWindChillInC() {
		assertNotNull("-1C and 10m/s wind", WindChillUtil.calcWindChillInC(-1d, 10d));
		Double delta = 0.1;
		Double res1 = WindChillUtil.calcWindChillInC(-15d, 10d);
		assertEquals("-15C and 10m/s wind", -26.9, res1, delta);
		Double res2 = WindChillUtil.calcWindChillInC(10d, 25d);
		assertEquals("10C and 25m/s wind", 4.1, res2, delta);
		Double res3 = WindChillUtil.calcWindChillInC(0d, 0d);
		assertNull("0C and no wind", res3);
	}

	@Test
	public void calcWindChillInF() {
		assertNotNull("-1C and 10m/s wind", WindChillUtil.calcWindChillInF(-1d, 10d));
		Double delta = 0.1;
		Double res1 = WindChillUtil.calcWindChillInF(-15d, 10d);
		assertEquals("-15C and 10m/s wind", -16.4, res1, delta);
		Double res2 = WindChillUtil.calcWindChillInF(10d, 25d);
		assertEquals("10C and 25m/s wind", 39.4, res2, delta);
		Double res3 = WindChillUtil.calcWindChillInF(0d, 0d);
		assertNull("0C and no wind", res3);
	}
}