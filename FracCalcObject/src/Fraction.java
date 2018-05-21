//import fracCalcObject.Fraction;

public class Fraction {
	private int numerator;
	private int denominator;
	private int whole;
	private String wholeAsStr;
	private String numeratorAsStr;
	private String denominatorAsStr;
	
	//Constructor
	public Fraction(String operand) {
		if(operand.contains("_") && operand.contains("/")) {
    		String[] wholeNumSplit = (operand.split("_"));
    		String[] fracSplit = wholeNumSplit[wholeNumSplit.length-1].split("/");
    		wholeAsStr = wholeNumSplit[0];    		
    		numeratorAsStr = fracSplit[0];
    		denominatorAsStr = fracSplit[1];
    	}else if(operand.contains("/")&&!operand.contains("_")){
    		String[] fracSplit = operand.split("/");
    		wholeAsStr = "0";
    		numeratorAsStr = fracSplit[0];
    		denominatorAsStr = fracSplit[1];
    	}else {
    		wholeAsStr = operand;
    		numeratorAsStr = "0";
    		denominatorAsStr = "1";
    	}
		//String to int
		String[] operandArr = {wholeAsStr, numeratorAsStr, denominatorAsStr};
		int[] operandInt = new int[3];
        for(int i = 0; i < operandArr.length; i++) {
        	operandInt[i] = Integer.parseInt(operandArr[i]);      	
        }
        whole = operandInt[0];
        numerator = operandInt[1];
        denominator = operandInt[2];
	}

	public Fraction() {
		// TODO Auto-generated constructor stub
	}

	//toString method
	public static String toString(Fraction answer) {
		if(answer.whole == 0) {
			if(answer.numerator == 0) {
				return "0";
			}else{
				return (answer.numerator +"/"+ answer.denominator);
			}
		}else if(answer.numerator == 0){
			return "" + answer.whole;
		}else {
			return answer.whole +"_"+ answer.numerator + "/" + answer.denominator;
		}
		
		//return "";
	}
	
	//to improper fraction
	public static void toImproperFrac(Fraction operand) {
		if(operand.whole<0) {
			operand.numerator = absValue(operand.whole)*operand.denominator+operand.numerator;
			operand.numerator = operand.numerator * -1;
		}else {
			operand.numerator = operand.whole*operand.denominator+operand.numerator;
		}
		operand.whole = 0;
	}
    
	//to absolute value
	public static int absValue(int number) {
		if(number<0) {
			return number*-1;
		}else {
			return number;
		}
	}
	
	//finds common denominator
	public static void commonDenominator(Fraction operand1, Fraction operand2) {
    	int denominatorTemp1 = operand1.denominator;
    	int denominatorTemp2 = operand2.denominator;
    	operand1.numerator =  operand1.numerator * denominatorTemp2;
    	operand1.denominator =  operand1.denominator * denominatorTemp2;
    	operand2.numerator =  operand2.numerator * denominatorTemp1;
    	operand2.denominator =  operand2.denominator * denominatorTemp1;
    	
    }
	
	//operator methods
	public static void add(Fraction answer, Fraction operand1, Fraction operand2) {
    	answer.numerator = operand1.numerator + operand2.numerator;
    	answer.denominator = operand1.denominator;
    	
    }
    public static void subtract(Fraction answer, Fraction operand1, Fraction operand2) {
    	operand2.numerator = operand2.numerator * -1;
    	add(answer, operand1, operand2);
    }    
    public static void multiply(Fraction answer, Fraction operand1, Fraction operand2) {
    	answer.numerator = operand1.numerator * operand2.numerator;
    	answer.denominator = operand1.denominator * operand2.denominator;
    }    
    public static void divide(Fraction answer, Fraction operand1, Fraction operand2) {
    	int tempDenom = operand2.denominator;
    	operand2.denominator = operand2.numerator;
    	operand2.numerator = tempDenom;
    	multiply(answer, operand1, operand2);
    }
    
    //reduces answer
    public static void reduce(Fraction answer) {
    	int gcf = Fraction.gcf(answer.numerator, answer.denominator);
	    if(gcf != 0) {	
	    	answer.numerator = answer.numerator/gcf;
	    	answer.denominator = answer.denominator/gcf;
	    }
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

	//converts answer to mixed number
	public static void toMixedNum(Fraction answer) {
		answer.whole = answer.numerator/answer.denominator;
		if(answer.whole != 0) {
			answer.numerator = Fraction.absValue(answer.numerator%answer.denominator);
		}else {
			answer.numerator = answer.numerator%answer.denominator;
		}
		answer.denominator = Fraction.absValue(answer.denominator);
	}
}
