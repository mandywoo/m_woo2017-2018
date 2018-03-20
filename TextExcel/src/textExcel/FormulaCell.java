package textExcel;

public class FormulaCell extends RealCell{
	private String command;
	public FormulaCell(String command) {
		super(command);
	}
	@Override
	public String abbreviatedCellText() {
		return "something ";
	}
	@Override
	public String fullCellText() {
		return command;
	}
	@Override
	public double getDoubleValue() {
		return 0;
	}

}
