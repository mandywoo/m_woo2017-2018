package textExcel;

public class TextCell implements Cell{
	String strAnswer;
	public TextCell(String strAnswer) {
		this.strAnswer = strAnswer;
	}
	public String fullCellText() {
		return strAnswer;
	}
	public String abbreviatedCellText() {
		String finalStr = null;
		if(strAnswer.length()>10) {
			finalStr = strAnswer.substring(1, 11);
		}else if(strAnswer.length()<10) {
			finalStr = (strAnswer + "          ").substring(1, 11);
		}
		return finalStr;
	}
}
