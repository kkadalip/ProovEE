package proov.enums;

public enum TempEnum {
	C("Celsius"),
	F("Fahrenheit"),
	K("Kelvin");

	private final String code;
	
	public String getCode() {
		return code != null ? code : "";
	}

	TempEnum(String code) {
		this.code = code;
	}
}
