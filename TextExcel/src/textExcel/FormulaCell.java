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
		double answer = Double.parseDouble(formula[1]);
		for(int i = 0; i < formula.length-1; i+=2) {
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
