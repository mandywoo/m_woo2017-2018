package textExcel;
import java.util.Arrays;

//test////////

public class FormulaCell extends RealCell{
	//spreadsheet field to hold current spreadsheet to use getCell in Spreadsheet
	private Spreadsheet spreadsheet;
	public FormulaCell(String command, Spreadsheet spreadsheet) {
		super(command);
		this.spreadsheet = spreadsheet;
	}
	@Override
	public String abbreviatedCellText() {
		return (Double.toString(getDoubleValue()) + "          ").substring(0, 10);
	}
	@Override
	public String fullCellText() {
		return getCommand();
	}
	@Override
	public double getDoubleValue() {
		String[] formula = getCommand().split(" ");
		//calculates sum and avg
		if(formula[1].equalsIgnoreCase("SUM") || formula[1].equalsIgnoreCase("AVG")){
			//Split to find location
			String[] numBlockLoc = formula[2].split("-");
			String cell1 = numBlockLoc[0];
			String cell2 = numBlockLoc[1];		
			//create cell locations
			SpreadsheetLocation cell1Loc = new SpreadsheetLocation(cell1);
			SpreadsheetLocation cell2Loc = new SpreadsheetLocation(cell2);
			//get number of rows and columns to get length of array
			int numCols = cell2Loc.getCol()-cell1Loc.getCol()+1;
			int numRows = cell2Loc.getRow()-cell1Loc.getRow()+1;
			Cell[] numArr = new Cell[numCols*numRows];

			//index of array
			int numArrCounter = 0;
			
			for(int i = cell1Loc.getCol()+65; i <= cell2Loc.getCol()+65; i++) {
				for(int j = cell1Loc.getRow()+1; j <= cell2Loc.getRow()+1; j++) {
					//recreate String of cell location that can change with for loop
					String cellId = "" + (char)i + j;
					//create the cell location
					SpreadsheetLocation cellLoc = new SpreadsheetLocation(cellId);
					//add cell to array
					numArr[numArrCounter] = spreadsheet.getCell(cellLoc);
					//index++
					numArrCounter++;
				}
			}
			
			//sum
			double sum = 0;
			//add the double value of the cell to sum
			for(Cell num: numArr) {
				sum += ((RealCell)num).getDoubleValue();
			}	
			
			//if avg then sum divided by length of arrays which is also the number of doubles
			if(formula[1].equalsIgnoreCase("AVG")) {
				//sum divided by counter
				sum = sum/numArrCounter;
			}
			
			//returns sum or average
			return sum;
		}else {
			//if no sum or avg then just convert and perform operations
			convertArrToNum(formula);
			return doOperation(formula);
		}
	}

	//if formula has array locations, this converts the locations to numbers
	public String[] convertArrToNum(String[] formula) {
		for(int i = 0; i < formula.length; i++) {	
			if(formula[i].matches(".*[A-L].*") || formula[i].matches(".*[a-l].*")) {
				//creates spreadsheet location from the string cell location
				SpreadsheetLocation cellLocation = new SpreadsheetLocation(formula[i]);
				//creates new cell that stores the cell at cellLocation
				Cell value = spreadsheet.getCell(cellLocation);
				//the new cell in converted to a real cell so we can get its double value
			    double locationToNum = ((RealCell) value).getDoubleValue();
			    //the formula array is then filled with the number
			    formula[i] = Double.toString(locationToNum);
			}
		}
		return formula;
	}
	
	public double doOperation(String[] formula) {
		//answer starts with first number
		double answer = Double.parseDouble(formula[1]);
		for(int i = 0; i < formula.length-3; i+=2) {
			//operator is at even indexes
			String operator = formula[i+2];
			//numbers are on odd indexes
			double num = Double.parseDouble(formula[i+3]);
			//does operations
			if(operator.equals("+")) {
				answer += num;
			}else if(operator.equals("-")) {
				answer -= num;
			}else if(operator.equals("*")) {
				answer *= num;
			}else if(operator.equals("/")) {
				answer /= num;
			}
		} 	
		return answer;
	}

}
