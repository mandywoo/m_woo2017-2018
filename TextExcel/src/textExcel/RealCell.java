//Mandy Woo

package textExcel;

public abstract class RealCell implements Cell{
	
	private String command;
	
	public RealCell(String command) {
		this.command = command;

	}
	
	//will be inherited by value, percent, and formula cell
	public abstract double getDoubleValue();
	
	//gives subclasses access to command
	public String getCommand() {
		return command;
	}
	
	
}
