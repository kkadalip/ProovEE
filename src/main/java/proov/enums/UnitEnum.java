package proov.enums;

public enum UnitEnum {
	ANGLE("Degree", "°"),
	PERCENTAGE("Percentage", "%"),
	KM("Kilometre", "km"),
	MM("Millimetre", "mm"),
	MS("Ketres per second", "m/s"),
	HPA("Hectopascal", "hPa");

	private final String name;
	private final String symbol;

	UnitEnum(String name, String symbol) {
		this.name = name;
		this.symbol = symbol;
	}

	public String getName() {
		return name != null ? name : "";
	}

	public String getSymbol() {
		return symbol != null ? symbol : "";
	}
}
