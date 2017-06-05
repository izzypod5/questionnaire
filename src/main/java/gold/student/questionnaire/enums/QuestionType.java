package gold.student.questionnaire.enums;

public enum QuestionType {

	FREE_TEXT("Free Text", "FT"),
	TEXT("Text", "T"),
	NUMBER("Number", "N"),
	DATE("Date", "D"),
	SELECT("Select", "S"),
	RADIO("Radio", "R");

	public static final QuestionType[] VALUES = values();
	private final String name;
	private final String abbr;

	private QuestionType(String name, String abbr) {
		this.name = name;
		this.abbr = abbr;
	}

	public String getName() {
		return name;
	}

	public String getAbbr() {
		return abbr;
	}

	public static QuestionType forId(String abbr) {
		for (QuestionType type : VALUES) {
			if (type.abbr.equals(abbr)) {
				return type;
			}
		}
		return null;
	}

}
