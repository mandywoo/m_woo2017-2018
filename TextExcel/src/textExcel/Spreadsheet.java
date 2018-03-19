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
		System.out.println(Arrays.toString(commandArr));
		SpreadsheetLocation cellLocation;
		
//		if(commandArr[2].equals("\"") && commandArr[commandArr.length-1].equals("\"")) {
//			String spaces = command.substring(command.indexOf("\"")+1,command.indexOf("\""));
//			cellLocation = new SpreadsheetLocation(commandArr[0]);
//			textValue = new TextCell(spaces);
//			cellArr[cellLocation.getRow()][cellLocation.getCol()] = textValue;
//		}
		
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
			}else if(commandArr[2].equals("\"") && commandArr[commandArr.length-1].equals("\"")) {
				String spaces = command.substring(command.indexOf("\""));
				spaces = spaces.substring(1, spaces.length()-1);
				textValue = new TextCell(spaces);
		    }else{
				String commandArrElem2 = "";
				for(int i = 2; i < commandArr.length; i++) {
					commandArrElem2 += commandArr[i];
					if(i < commandArr.length-1) {
						commandArrElem2 +=" ";
					}
				}
				textValue = new TextCell(commandArrElem2);
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
