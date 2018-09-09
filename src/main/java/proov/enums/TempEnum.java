package proov.enums;

public enum TempEnum {
	C("Celsius", "°C"),
	F("Fahrenheit", "F");

	private final String name;
	private final String symbol;

	TempEnum(String name, String symbol) {
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
