package textExcel;
import java.util.Arrays;

public class FormulaCell extends RealCell{
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
		if(formula[1].equals("SUM") || formula[1].equals("AVG")){
			String[] numBlockLoc = formula[2].split("-");
			String cell1 = numBlockLoc[0];
			String cell2 = numBlockLoc[1];
			
			//find sum and keep counter
			
			SpreadsheetLocation cell1Loc = new SpreadsheetLocation(cell1);
			SpreadsheetLocation cell2Loc = new SpreadsheetLocation(cell2);
			int numCols = cell2Loc.getCol()-cell1Loc.getCol()+1;
			int numRows = cell2Loc.getRow()-cell1Loc.getRow()+1;
//			System.out.println(numCols);
//			System.out.println(numRows);
//			System.out.println("cell2 Row: " + cell2Loc.getRow() + "   cell2 Column: " + cell2Loc.getCol());
			String[] numArr = new String[numCols*numRows];
		
//			System.out.println(numArr.length);
			
//			System.out.println(cell1Loc.getRow());
//			System.out.println(cell2Loc.getRow());
//			int counter = 0;
//			for(int i = cell1Loc.getRow(); i <= cell2Loc.getRow(); i++) {
//				System.out.println(cell1Loc.getRow());
//				System.out.println(cell2Loc.getRow());
//				numArr[counter]="a";
//				counter++;
//			}
			
			int numArrCounter = 0;
			for(int i = cell1Loc.getCol()+65; i <= cell2Loc.getCol()+65; i++) {
				for(int j = cell1Loc.getRow()+1; j <= cell2Loc.getRow()+1; j++) {
					System.out.println("COL: "+i);
					System.out.println("ROW: "+j);
					String cellId = "" + (char)i + j;
					System.out.println(cellId);
					SpreadsheetLocation cellLoc = new SpreadsheetLocation(cellId);
					numArr[numArrCounter] += spreadsheet.getCell(cellLoc);
					numArrCounter++;
				}
			}
			System.out.println(Arrays.toString(numArr));
			//add all numbers
			
		}
		if(formula[1].equals("AVG")) {
			//sum divided by counter
			
			//ignore test 1
		}
		//convertArrToNum(formula);
		

		//return doOperation(formula);
		return 0;
	}

	public String[] convertArrToNum(String[] formula) {
		for(int i = 0; i < formula.length; i++) {	
			if(formula[i].matches(".*[A-L].*") || formula[i].matches(".*[a-l].*")) {
				SpreadsheetLocation cellLocation = new SpreadsheetLocation(formula[i]);
				
				Cell value = spreadsheet.getCell(cellLocation);
			    double locationToNum = ((RealCell) value).getDoubleValue();
			    formula[i] = Double.toString(locationToNum);
			}
		}
		return formula;
	}
	
	public double doOperation(String[] formula) {
		double answer = Double.parseDouble(formula[1]);
		for(int i = 0; i < formula.length-3; i+=2) {
			String operator = formula[i+2];
			double num = Double.parseDouble(formula[i+3]);
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
