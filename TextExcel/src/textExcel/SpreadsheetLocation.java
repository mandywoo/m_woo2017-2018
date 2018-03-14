package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	
	private char cellLetter;
	private String cellNum;
	public SpreadsheetLocation(String cellName)
    {
		cellLetter = cellName.charAt(0);
		cellNum = cellName.substring(1);
    }
	
    @Override
    public int getRow()
    {
    	return Integer.parseInt(cellNum) - 1;
    }
    @Override
    public int getCol()
    {
    	cellLetter = Character.toUpperCase(cellLetter);
    	return cellLetter - 65;
    
    }
    
 

}
