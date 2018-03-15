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
		String finalStr = null;
		if(strAnswer.length()>10) {
			finalStr = String.format("[%1$.10s]", strAnswer);
		}else if(strAnswer.length()<10) {
			finalStr = String.format("[%1$-10-StrValue.length()s]", strAnswer);
		}
		return finalStr;
	}
}
