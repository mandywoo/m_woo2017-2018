package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	
	private int NUM_ROWS = 20;
	private int NUM_COLS = 12;
	private Cell[][] cellArr = new Cell[NUM_ROWS][NUM_COLS];
	public Spreadsheet(){
		for(int i = 0; i < cellArr.length; i++) {
			for(int j = 0; j < cellArr[i].length; j++) {
				EmptyCell newCell = new EmptyCell();
				cellArr[i][j] = newCell;
			}
		}
	}
	
	@Override
	public String processCommand(String command)
	{
		String[] commandArr = command.split(" ");
		int colNum = Character.toUpperCase(command.charAt(0)) - 'A';
		int rowNum = Integer.parseInt(commandArr[0].substring(1)) - 1;
		if(!command.contains(" ")) {
		----	if("clear".equals(commandArr[0])) {
				Spreadsheet clearedGrid = new Spreadsheet();
				//return STring of grid --- getGridText()
				return "c";
			}else {
				return "a";
				//return cellArr[rowNum][colNum].fullCellText();
			}
		}
			
		if(commandArr[2] instanceof String) {
			TextCell textValue = new TextCell(commandArr[2]);
			cellArr[rowNum][colNum] = textValue;
			//AND THEN RETURN THE GRID WITH THIS TEXTVALUE IN IT ---getGridText()
			return "b";
		}
			
		
		
		
		
		return "wrong";
	}

	@Override
	public int getRows()
	{
		return NUM_ROWS;
	}

	@Override
	public int getCols()
	{
		return NUM_COLS;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return cellArr[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		String grid = "";
		String row1 = "";
		for(int i = 65; i < 77; i++) {
			row1 += "|" + (char)i + "         ";
		}
		grid += "   " + row1 + "|";
		
		//IMPORTANTE CHANGE 10SPACES TO CELLS THAT HAVE BEEN FORMATTED
		for(int i = 1; i <= NUM_ROWS; i++) {
			String num = Integer.toString(i);
			if(i < 10) {
				num += " ";
			}
			String row = num + " |";
			for(int j = 0; j < NUM_COLS; j++) {
				row += "          |"; 
			}
			grid += "\n" + row;
		}
		
		return grid;
	}

}
