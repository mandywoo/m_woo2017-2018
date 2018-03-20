package textExcel;

public class TextCell implements Cell{
	//str for a text cell
	String text;
	public TextCell(String strAnswer) {
		this.text = strAnswer;
	}
	
	public String fullCellText() {
		return text;
	}
	
	public String abbreviatedCellText() {
		String finalStr = null;
		String text2 = text.substring(0,text.length()-1);
		finalStr = (text2 += "          ").substring(1, 11);
		return finalStr;
	}
}
