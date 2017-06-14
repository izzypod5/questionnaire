package gold.student.questionnaire.enums;

public enum QuestionFormat {

	FREE_TEXT("Free Text", "FT"),
	TEXT("Text", "T"),
	NUMBER("Number", "N"),
	DATE("Date", "D"),
	SELECT("Select", "S"),
	RADIO("Radio", "R");

	public static final QuestionFormat[] VALUES = values();
	private final String name;
	private final String abbr;

	private QuestionFormat(String name, String abbr) {
		this.name = name;
		this.abbr = abbr;
	}

	public String getName() {
		return name;
	}

	public String getAbbr() {
		return abbr;
	}

	public static QuestionFormat forId(String abbr) {
		for (QuestionFormat type : VALUES) {
			if (type.abbr.equals(abbr)) {
				return type;
			}
		}
		return null;
	}

}
