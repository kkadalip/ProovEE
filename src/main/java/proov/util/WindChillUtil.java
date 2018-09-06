package proov.util;

import java.util.EnumSet;

import lombok.extern.slf4j.Slf4j;
import proov.enums.TempEnum;

@Slf4j
public class WindChillUtil {
	private WindChillUtil() {
		throw new IllegalStateException("Utility class!");
	}

	public static Double calculateWindChillInCelsius(Double actualTempC, Double windVelocityMs) {
		Double windSpeedKmh = UnitUtil.msToKmh(windVelocityMs);
		return calculateWindChill(actualTempC, windSpeedKmh, TempEnum.C);
	}

	public static Double calculateWindChillInFahrenheit(Double actualTempC, Double windVelocityMs) {
		Double windSpeedMph = UnitUtil.msToMph(windVelocityMs);
		Double actualTempF = UnitUtil.celsiusToFahrenheit(actualTempC);
		return calculateWindChill(actualTempF, windSpeedMph, TempEnum.F);
	}

	private static Double calculateWindChill(Double temp, Double windSpeed, TempEnum tempEnum) {
		// https://www.freemathhelp.com/wind-chill.html
		if (temp == null || windSpeed == null || !EnumSet.of(TempEnum.C, TempEnum.F).contains(tempEnum)) {
			return null;
		}
		try {
			Double tempMultiplied = 0.6215 * temp;
			Double windPow = Math.pow(windSpeed, 0.16);
			Double result = null;
			if (TempEnum.C.equals(tempEnum)) {
				result = UnitUtil.round(13.12 + (tempMultiplied) - (11.37 * windPow) + (0.3965 * temp * windPow));
			} else if (TempEnum.F.equals(tempEnum)) {
				result = UnitUtil.round(35.74 + (tempMultiplied) - (35.75 * windPow) + (0.4275 * temp * windPow));
			} else {
				log.error("Temperature scale not applicable. " + tempEnum);
			}
			return result != null && result < temp ? result : null;
		} catch (Exception ex) {
			log.error("Calculating wind chill failed.", ex);
		}
		return null;
	}
}
