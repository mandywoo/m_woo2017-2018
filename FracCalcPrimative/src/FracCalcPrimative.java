import java.util.Scanner;

public class FracCalcPrimative {
	 public static void main(String[] args) {
		 // TODO: Read the input from the user and call produceAnswer with an equation
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
	        // TODO: Implement this function to produce the solution to the input
	        
	    	//Splits input to get operand1 and operand2
	    	String[] splitInput = input.split(" ");
	        String operand1 = splitInput[0];
	        String operand2 = splitInput[splitInput.length-1];
	        String operator = splitInput[1];
	        //put operand 1 and 2 info into separate arrays
	        String[] operand1Arr = splitOperand(operand1);
	        String[] operand2Arr = splitOperand(operand2);
	        //String --> int
	        int[] operand1Int = new int[3];
	        int[] operand2Int = new int[3];
	        for(int i = 0; i < operand1Arr.length; i++) {
	        	operand1Int[i] = Integer.parseInt(operand1Arr[i]);
	        	operand2Int[i] = Integer.parseInt(operand2Arr[i]);        	
	        }
	        //improper fraction
	        int[] impropFrac1 = toImproperFrac(operand1Int);
	        int[] impropFrac2 = toImproperFrac(operand2Int);
	        //common denominator
	        commonDenominator(impropFrac1, impropFrac2);
	        
	        //match and solve
	        int[] finalArr = new int[2];
	        if(operator.equals("+")) {
	        	finalArr = add(impropFrac1, impropFrac2);
	        }else if(operator.equals("-")) {
	        	finalArr = subtract(impropFrac1, impropFrac2);
	        }else if(operator.equals("*")) {
	        	finalArr = multiply(impropFrac1, impropFrac2);
	        }else if(operator.equals("/")) {
	        	finalArr = divide(impropFrac1, impropFrac2);
	        }
	        //reduce
	        int gcf = gcf(finalArr[0], finalArr[1]);
	        finalArr[0] = finalArr[0]/gcf;
	        finalArr[1] = finalArr[1]/gcf;
	        //mixed num
	        String finalFrac = toMixedNum(finalArr[0], finalArr[1]);
	        return finalFrac;
	    }
		
	    //split operand into wholeNum, numerator, and denominator
	    public static String[] splitOperand(String operand) {
	    	//declared variables
	    	String wholeNum;
	    	String numerator;
	    	String denominator;
	    	if(operand.contains("_") && operand.contains("/")) {
	    		String[] wholeNumSplit = (operand.split("_"));
	    		String[] fracSplit = wholeNumSplit[wholeNumSplit.length-1].split("/");
	    		wholeNum = wholeNumSplit[0];    		
	    		numerator = fracSplit[0];
	    		denominator = fracSplit[1];
	    	}else if(operand.contains("/")&&!operand.contains("_")){
	    		String[] fracSplit = operand.split("/");
	    		wholeNum = "0";
	    		numerator = fracSplit[0];
	    		denominator = fracSplit[1];
	    	}else {
	    		wholeNum = operand;
	    		numerator = "0";
	    		denominator = "1";
	    	}
	        
	        String[] operandInfo = {wholeNum, numerator, denominator};
	        return operandInfo;
	    }
	    
	    // TODO: Fill in the space below with any helper methods that you think you will need
		
	    //change to improper fraction
	    public static int[] toImproperFrac(int[] operandIntArr) {
			if(operandIntArr[0]<0) {
				operandIntArr[1] = absValue(operandIntArr[0])*operandIntArr[2]+operandIntArr[1];
				operandIntArr[1] = operandIntArr[1] * -1;
			}else {
				operandIntArr[1] = operandIntArr[0]*operandIntArr[2]+operandIntArr[1];
			}
			operandIntArr[0] = 0;
			return operandIntArr;
		}
	    
		public static int absValue(int number) {
			if(number<0) {
				return number*-1;
			}else {
				return number;
			}
		}
		public static void commonDenominator(int [] improperFrac1, int[] improperFrac2) {
	    	int denominator1 = improperFrac1[2];
	    	int denominator2 = improperFrac2[2];
	    	improperFrac1[1] =  improperFrac1[1] * denominator2;
	    	improperFrac1[2] =  improperFrac1[2] * denominator2;
	    	improperFrac2[1] =  improperFrac2[1] * denominator1;
	    	improperFrac2[2] =  improperFrac2[2] * denominator1;
	    }
		public static int[] add(int[] fracArr1, int[] fracArr2) {
	    	int[] fraction = new int[2];
	    	fraction[0] = fracArr1[1] + fracArr2[1];
	    	fraction[1] = fracArr1[2];
	    	return fraction;
	    }
	    
	    public static int[] subtract(int[] fracArr1, int[] fracArr2) {
	    	fracArr2[1] = fracArr2[1] * -1;
	    	System.out.println(fracArr2[1]);
	    	return add(fracArr1, fracArr2);
	    }
	    
	    public static int[] multiply(int[] fracArr1, int[] fracArr2) {
	    	int[] fraction = new int[2];
	    	fraction[0] = fracArr1[1] * fracArr2[1];
	    	fraction[1] = fracArr1[2] * fracArr2[2];
	    	return fraction;
	    }
	    
	    public static int[] divide(int[] fracArr1, int[] fracArr2) {
	    	int tempDenom = fracArr2[2];
	    	fracArr2[2] = fracArr2[1];
	    	fracArr2[1] = tempDenom;
	    	return multiply(fracArr1, fracArr2);
	    }
	    
		//returns greatest common factor of two integers
		public static int gcf(int num1, int num2) {
			//ex: 10,25
			while(num2 != 0){
				int num1alt = num1;
		        //=10, 25, 10
				num1 = num2;
				//=25, 10, 5
		        num2 = num1alt % num2; 
		        //=10, 5, 0
		    }
			//num1= 5
		    return num1;
		}	
		public static String toMixedNum(int numerator, int denominator) {
			int wholeNum = numerator/denominator;
			int newNumerator;
			if(wholeNum != 0) {
				newNumerator = absValue(numerator%denominator);
			}else {
				newNumerator = numerator%denominator;
			}
			
			int newDenominator = absValue(denominator);
			if(wholeNum == 0) {
				
				if(newNumerator == 0) {
					return "0";
				}else{
					return (newNumerator +"/"+ newDenominator);
				}
			}else if(newNumerator == 0){
				return "" + wholeNum;
			}
			return (wholeNum + "_" + newNumerator +"/"+ newDenominator);
		}
}
