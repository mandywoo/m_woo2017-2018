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
		String strAnswer2 = strAnswer.substring(0,strAnswer.length()-1);
		finalStr = (strAnswer2 += "          ").substring(1, 11);
		return finalStr;
	}
}
