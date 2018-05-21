import java.util.Scanner;

//import FracCalcObject.Fraction;

public class FracCalcObject {
    public static void main(String[] args){
    	Scanner userInput = new Scanner(System.in);
    	boolean quit = false;
    	while(!quit) {
    		String input = userInput.nextLine();
    		System.out.println(produceAnswer(input));
    		System.out.println("quit?");
    		String finished = userInput.nextLine();
    		if(finished.equals("quit")) {
    			quit=true;
    		}
    	}	
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input){ 
        String[] splitInput = input.split(" ");
        Fraction operand1 = new Fraction(splitInput[0]);
        Fraction operand2 = new Fraction(splitInput[splitInput.length-1]);
        Fraction answer = new Fraction();
        String operator = splitInput[1];
        //improper fraction
        Fraction.toImproperFrac(operand1);
        Fraction.toImproperFrac(operand2);
        //common denominator
        Fraction.commonDenominator(operand1, operand2);
      
        if(operator.equals("+")) {
        	Fraction.add(answer, operand1, operand2);
        }else if(operator.equals("-")) {
        	Fraction.subtract(answer, operand1, operand2);
        }else if(operator.equals("*")) {
        	Fraction.multiply(answer, operand1, operand2);
        }else if(operator.equals("/")) {
        	Fraction.divide(answer, operand1, operand2);
        }
        Fraction.reduce(answer);
        Fraction.toMixedNum(answer);
        return Fraction.toString(answer);
    }
}