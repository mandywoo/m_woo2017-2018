package textExcel;

import java.util.Arrays;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	
	private int NUM_ROWS = 20;
	private int NUM_COLS = 12;
	private Cell[][] cellArr = new Cell[NUM_ROWS][NUM_COLS];
	private Cell newCell = new EmptyCell();
	public Spreadsheet(){
		for(int i = 0; i < NUM_ROWS; i++) {
			for(int j = 0; j < NUM_COLS; j++) {
				
				cellArr[i][j] = newCell;
			}
		}
	}
	
	@Override
	public String processCommand(String command)
	{
		String[] commandArr = command.split(" ");
		SpreadsheetLocation cellLocation;
		if(commandArr.length == 1) {
			if(commandArr[0].equalsIgnoreCase("clear")) {
				for(int i = 0; i < cellArr.length; i++) {
					for(int j = 0; j < cellArr[i].length; j++) {
						cellArr[i][j] = newCell;
					}
				}
				return getGridText();
			}else {
				cellLocation = new SpreadsheetLocation(commandArr[0]);
				return cellArr[cellLocation.getRow()][cellLocation.getCol()].fullCellText();
			}
		}else if(commandArr.length == 2) {
			cellLocation = new SpreadsheetLocation(commandArr[1]);
			cellArr[cellLocation.getRow()][cellLocation.getCol()] = newCell;
			return getGridText();
		}else{
			TextCell textValue;
			if(commandArr.length == 3) {
				textValue = new TextCell(commandArr[2]);
			}else{
				String spaces = command.substring(command.indexOf("\""));
				spaces = spaces.substring(0, spaces.length());
				textValue = new TextCell(spaces);
			}
			cellLocation = new SpreadsheetLocation(commandArr[0]);
			cellArr[cellLocation.getRow()][cellLocation.getCol()] = textValue;
			return getGridText();
		}
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
		
		for(int i = 0; i < NUM_ROWS; i++) {
			String num = Integer.toString(i+1);
			if(i < 9) {
				num += " ";
			}
			String row = num + " |";
			for(int j = 0; j < NUM_COLS; j++) {
				row += cellArr[i][j].abbreviatedCellText() +"|"; 
			}
			grid += "\n" + row;
		}
		grid += "\n";
		return grid;
	}

}
