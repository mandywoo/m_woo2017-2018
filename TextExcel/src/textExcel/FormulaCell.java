package textExcel;

public class FormulaCell extends RealCell{
	public FormulaCell(String command) {
		super(command);
	}
	@Override
	public String abbreviatedCellText() {
		return (Double.toString(getDoubleValue())+"          ").substring(0, 10);
	}
	@Override
	public String fullCellText() {
		return getCommand();
	}
	@Override
	public double getDoubleValue() {
		String[] formula = getCommand().split(" ");
		//double answer;
		
//		if(formula[1].matches(".*[A-L].*") || formula[1].matches(".*[a-l].*")) {
//			SpreadsheetLocation cellLocation = new SpreadsheetLocation(formula[1]);
//			Cell value = Spreadsheet.getCell(cellLocation);
//		    answer = ((RealCell) value).getDoubleValue();
//		    System.out.println(answer);
//			System.out.println("a");
//			
//		}else {
//			answer = Double.parseDouble(formula[1]);
//		}
		
		//double answer = 100.0;
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
