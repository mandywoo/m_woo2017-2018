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
		if(strAnswer.length()<10) {
			String strAnswer1 = strAnswer.substring(0,strAnswer.length()-1);
			finalStr = (strAnswer1 += "          ").substring(1, 11);
			System.out.println("a");
		}else if(strAnswer2.length()>10) {
			System.out.println(strAnswer);
			finalStr = strAnswer.substring(1, 11);
			System.out.println("c");
		}else {
			String strNoQuotes = strAnswer.substring(1, strAnswer.length()-1);
			finalStr = strNoQuotes + "  ";
			System.out.println("b");
		}
		return finalStr;
	}
	
	
}
