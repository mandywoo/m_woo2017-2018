package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		Spreadsheet spreadsheet = new Spreadsheet();
		Scanner scanner = new Scanner(System.in);
		System.out.println(spreadsheet.getGridText());
		//TestsALL.Helper th = new TestsALL.Helper();
		//System.out.println(th.getText());
		
	    while(true){
			String input = scanner.nextLine();
			if(input.equals("quit")) {
				break;
			}else {
				System.out.println(spreadsheet.processCommand(input));
			}
	    } 
	}
}
