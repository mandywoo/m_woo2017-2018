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
		if(!command.contains(" ")) {
			int colNum = Character.toUpperCase(command.charAt(0)) - 'A';
			int rowNum = Integer.parseInt(command.substring(1)) - 1;
			return cellArr[rowNum][colNum].fullCellText();
		}
		
		String[] commandArr = command.split(" ");
		
		return "";
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
