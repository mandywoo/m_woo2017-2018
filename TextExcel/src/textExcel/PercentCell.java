package textExcel;

public class PercentCell extends ValueCell{
	public PercentCell(String command) {
		super(command);
	}
	
	//returns percent with % sign without decimal
	public String abbreviatedCellText() {
		String percent = getCommand().substring(0, getCommand().indexOf("."));
		return (percent + ("%") + "          ").substring(0, 10);
	}
	
	//returns decimal value of percent
	public String fullCellText() {
		return Double.toString(getDoubleValue()/100.0);
	}
	
	//converts string without % sign to double
	public double getDoubleValue() {
		return Double.parseDouble(getCommand().substring(0, getCommand().length()-1));
	}
}
