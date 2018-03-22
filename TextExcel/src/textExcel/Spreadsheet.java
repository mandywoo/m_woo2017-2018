package textExcel;

import java.util.Arrays;

import com.sun.xml.internal.ws.util.StringUtils;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	//Set number of rows and columns
	private int NUM_ROWS = 20;
	private int NUM_COLS = 12;
	//Creates new 2D array to hold all values
	private Cell[][] cellArr = new Cell[NUM_ROWS][NUM_COLS];
	//Creates new empty cell
	private Cell newCell = new EmptyCell();
	//Fills 2D array with empty cells
	public Spreadsheet(){
		for(int i = 0; i < NUM_ROWS; i++) {
			for(int j = 0; j < NUM_COLS; j++) {
				
				cellArr[i][j] = newCell;
			}
		}
	}
	
	//Takes user input and processes it
	@Override
	public String processCommand(String command)
	{
		//Split command 
		String[] commandArr = command.split(" ");
		SpreadsheetLocation cellLocation;
		
		//Location only
		if(commandArr.length == 1) {
			//Clears whole grid by filling with empty cells
			if(commandArr[0].equalsIgnoreCase("clear")) {
				for(int i = 0; i < cellArr.length; i++) {
					for(int j = 0; j < cellArr[i].length; j++) {
						cellArr[i][j] = newCell;
					}
				}
				return getGridText();
			}else {
				//Get value at location
				cellLocation = new SpreadsheetLocation(commandArr[0]);
				return cellArr[cellLocation.getRow()][cellLocation.getCol()].fullCellText();
			}
		//Clear location
		}else if(commandArr.length == 2) {
			cellLocation = new SpreadsheetLocation(commandArr[1]);
			cellArr[cellLocation.getRow()][cellLocation.getCol()] = newCell;
			return getGridText();
		}else{
			cellLocation = new SpreadsheetLocation(commandArr[0]);
			//TextCell
			if(command.contains("\"")) {
				TextCell textValue;
				if(commandArr.length == 3) {
					textValue = new TextCell(commandArr[2]);
				}else{
					String str = command.substring(command.indexOf("\""));
					str = str.substring(0, str.length());
					textValue = new TextCell(str);
				}
				
				cellArr[cellLocation.getRow()][cellLocation.getCol()] = textValue;
				
			}else {
				//RealCell
				String num = command.substring(command.indexOf(commandArr[2]));
				RealCell numValue;
				if(num.contains("%")) {
					 numValue = new PercentCell(num);	 
				}else if(num.contains("(")) {
					numValue = new FormulaCell(num);
				}else {
					numValue = new ValueCell(num);
				}
				cellArr[cellLocation.getRow()][cellLocation.getCol()] = numValue;
			}
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

	//Creates grid using abbreviated values of objects stored in 2D array
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
