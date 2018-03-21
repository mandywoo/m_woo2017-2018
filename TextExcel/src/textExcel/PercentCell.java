package textExcel;

public class PercentCell extends ValueCell{
	public PercentCell(String command) {
		super(command);
	}
	
	public String abbreviatedCellText() {
		String percent = getCommand().substring(0, getCommand().indexOf("."));
		return (percent + ("%") + "          ").substring(0, 10);
	}
	
	public String fullCellText() {
		return Double.toString(getDoubleValue()/100.0);
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(getCommand().substring(0, getCommand().length()-1));
	}
}
