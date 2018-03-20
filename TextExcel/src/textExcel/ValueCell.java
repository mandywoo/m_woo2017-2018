package textExcel;

public class ValueCell extends RealCell{

	public ValueCell(String command) {
		super(command);
		
	}

	@Override
	public String abbreviatedCellText() {
		String num = getCommand();
		return (num += "          ").substring(0, 10);
	}

	@Override
	public String fullCellText() {
		return getCommand();
	}

	@Override
	public double getDoubleValue() {
		return Double.parseDouble(getCommand());
	}

}
