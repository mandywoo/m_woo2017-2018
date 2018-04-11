//Mandy Woo

package textExcel;

public class EmptyCell implements Cell{
	
	//Looks like empty string in the grid
	public String abbreviatedCellText() {
		return "          ";
		
	} // text for spreadsheet cell display, must be exactly length 10
	
	//what is printed, it's an empty string
	public String fullCellText() {
		return "";
		
	} // text for individual cell inspection, not truncated or padded
}