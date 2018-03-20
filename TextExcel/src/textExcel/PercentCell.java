package textExcel;

public class PercentCell extends ValueCell{
	public PercentCell(String command) {
		super(command);
	}
	
	public String abbreviatedCellText() {
		String percent = getCommand().substring(0, getCommand().indexOf("."));
		return percent + ("%");
	}
	
	public String fullCellText() {
		return Double.toString(getDoubleValue()/100);
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(getCommand().substring(0, getCommand().length()));
	}
}
