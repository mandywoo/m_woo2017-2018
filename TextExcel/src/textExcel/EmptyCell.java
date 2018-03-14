package textExcel;

public class EmptyCell implements Cell{
	//private String strValue;
	
	public String abbreviatedCellText() {
//		String finalStr = null;
//		if(strValue.length()>10) {
//			finalStr = String.format("[%1$.10s]", strValue);
//		}else if(strValue.length()<10) {
//			finalStr = String.format("[%1$-10-StrValue.length()s]", strValue);
//		}
//		return finalStr;
		
		return "";
		
	} // text for spreadsheet cell display, must be exactly length 10
	public String fullCellText() {
		//return strValue;
		
		return "";
		
	} // text for individual cell inspection, not truncated or padded
}