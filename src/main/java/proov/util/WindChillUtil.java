package proov.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumSet;

import lombok.extern.slf4j.Slf4j;
import proov.enums.TempEnum;

@Slf4j
public class WindChillUtil {
	private WindChillUtil() {
		throw new IllegalStateException("Utility class!");
	}

	public static Double calculateWindChillInCelsius(Double actualTempC, Double windVelocityKmH) {
		return calculateWindChill(actualTempC, windVelocityKmH, TempEnum.C);
	}

	public static Double calculateWindChillInFahrenheit(Double actualTempC, Double windVelocityKmH) {
		return calculateWindChill(actualTempC, windVelocityKmH, TempEnum.F);
	}

	private static Double calculateWindChill(Double temp, Double windVelocityKmH, TempEnum tempEnum) {
		// https://www.freemathhelp.com/wind-chill.html
		if (temp == null || windVelocityKmH == null || !EnumSet.of(TempEnum.C, TempEnum.F).contains(tempEnum)) {
			return null;
		}
		try {
			Double windVelPow = Math.pow(windVelocityKmH, 0.16);
			Double tempMultiplied = 0.6215 * temp;
			if (TempEnum.C.equals(tempEnum)) {
				return round(13.12 + tempMultiplied - 11.37 * windVelPow + 0.3965 * temp * windVelPow);
			} else if (TempEnum.F.equals(tempEnum)) {
				return round(35.74 + tempMultiplied - 35.75 * windVelPow + 0.4275 * temp * windVelPow);
			} else {
				log.error("Temperature scale not applicable. " + tempEnum);
			}
			return null;
		} catch (Exception ex) {
			log.error("Calculating wind chill in " + tempEnum.getCode() + " failed.", ex);
		}
		return null;
	}

	private static Double round(Double value) {
		return round(value, 2);
	}

	private static Double round(Double value, int places) {
		if (value == null) {
			return null;
		}
		if (places < 0) {
			throw new IllegalArgumentException();
		}
		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}
