package textExcel;

public class TextCell implements Cell{
	String strAnswer;
	public TextCell(String strAnswer) {
		this.strAnswer = strAnswer;
	}
	public String fullCellText() {
		return "\"" + strAnswer + "\"";
	}
	public String abbreviatedCellText() {
		return strAnswer;
	}
}
