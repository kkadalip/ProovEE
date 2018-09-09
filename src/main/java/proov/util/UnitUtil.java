package proov.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UnitUtil {
	private UnitUtil() {
		throw new IllegalStateException("Utility class!");
	}

	static Double msToKmh(Double ms) {
		return ms != null ? ms * 3.6 : null;
	}

	static Double kmhToMs(Double kmh) {
		return kmh != null ? kmh / 3.6 : null;
	}

	static Double msToMph(Double ms) {
		return ms != null ? ms * (3600 / 1609.3) : null;
	}

	public static Double round(Double value) {
		return round(value, 2);
	}

	static Double round(Double value, int places) {
		if (value == null) {
			return null;
		}
		if (places < 0) {
			throw new IllegalArgumentException("Can not round to negative number of decimal places.");
		}
		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	static Double celsiusToFahrenheit(Double celsius) {
		return celsius != null ? (9.0 / 5.0) * celsius + 32 : null;
	}

	static Double fahrenheitToCelsius(Double fahrenheit) {
		return fahrenheit != null ? (5.0 / 9.0) * (fahrenheit - 32) : null;
	}
}
