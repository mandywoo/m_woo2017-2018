/* Mandy Woo
 * September 6, 2017
 * Our self written math library
 * it contains a series of methods to do basic math functions
 */
public class Calculate {
	//square the int input and returns int output
	public static int square(int operand) {
		return operand*operand;
	}
	//cube the int input and return int output
	public static int cube(int number) {
		return number*number*number;
	}
	//average of two double inputs and returns a double output
	public static double average(double number1, double number2) {
		return (number1+number2)/2;
	}
	//average of three double inputs and returns a double output
	public static double average(double number1, double number2, double number3) {
		return (number1+number2+number3)/3;
	}
	//converts double angle measurement to degrees and returns double
	public static double toDegrees(double angleMeasure) {
		return (angleMeasure*180)/3.14159;
	}
	//converts degree measurements to radians and returns double
	public static double toRadians(double degreeMeasure) {
		return (degreeMeasure*3.14159)/180;
	}
	//finds discriminant of double coefficients in a quadratic equation and returns double output
	public static double discriminant(double a, double b, double c) {
		return b*b-4*a*c;
	}
	//convert mixed number to improper fraction, input int and return String
	public static String toImproperFrac(int wholeNum, int numerator, int denominator) {
		int newNumerator = wholeNum*denominator+numerator;
		return ( newNumerator + "/" + denominator);
	}
	//convert improper fraction to mixed number, input int and return String
	public static String toMixedNum(int numerator, int denominator) {
		int wholeNum = numerator/denominator;
		int newNumerator = numerator%denominator;
		return (wholeNum + "_" + newNumerator +"/"+ denominator);
	}
	//foils form (ax + b)(cx+d) into String standard form
	public static String foil(int a, int b, int c, int d, String letter) {
		return (a*c) + letter + "^2 + " + (b*c+a*d) + letter + " + " + (b*d);
	}
	//figure if int num1 is divisible by int num2 and reurns boolean
	public static boolean isDivisibleBy(int num1,int num2) {
		if(num2==0) throw new IllegalArgumentException("It cannot except a zero");
		if(num1%num2==0) {
			return true;
		}else{
			return false;
		}
	}
	//returns absolute value of double input
	public static double absValue(double number) {
		if(number<0) {
			return number*-1;
		}else {
			return number;
		}
	}
	//returns greater number out of 2 double numbers 
	public static double max(double num1, double num2) {
		if(num1>num2) {
			return num1;
		}else{
			return num2;
		}
	}
	//returns greatest number out of 3 double numbers 
	public static double max(double num1, double num2, double num3) {
		if(num1>num2 && num1>num3) {
			return num1;
		}else if(num2>num1 && num2>num3){
			return num2;
		}else{
			return num3;
		}
	}
    //returns smaller number of two integers
	public static int min(int num1, int num2) {
		if(num1<num2) {
			return num1;
		}else{
			return num2;
		}
	}
	//rounds double number to 2 decimal places and returns double number
	public static double round2(double orig) {
		double result = 0.0;
		//shift decimal point 3 places and cut off remaining
		int tempInt = (int)(orig * 1000);
		//get 1's digit
		int roundNum = tempInt % 10;
		//discard the 1's place
		tempInt = tempInt / 10;
		//round up or down
		if(roundNum >= 5 && tempInt > 0) {
			tempInt++;
		}else if(roundNum <= -5 && tempInt < 0){
			tempInt--;
		}
		//move decimal place 2 and make it a double
		System.out.println(tempInt);
		result = tempInt / 100.0;
		
		return result;
		
	}
	// returns exponential result of number	
	public static double exponent(double number, int exponent) {
		if(exponent<0) throw new IllegalArgumentException("It cannot except a negative number");
		//store number in base
		double base = number;
		//multiplies the base by number for as many times as the exponent
		for(int i = 1; i < exponent; i++) {
			number = base * number;
		}
		return number;
	}	
	//return int factorial of a int number
	public static int factorial(int number) {
		if(number<0) throw new IllegalArgumentException("It cannot except a negative number");
		//for loop is decreasing number by one 
		for(int i = number - 1; i > 0; i--) {
			//multiplying number by decreasing number
			number *= i;
		}
		return number;
	}
	//returns boolean value for whether a number is a prime number
	public static boolean isPrime(int number) {
		//true/false value for isDivisibleBy
		boolean divisibleByBoolean = isDivisibleBy(number, 2);
		if(divisibleByBoolean == true) {
			return false;
		}else {
			return true;
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
	//approximate square root root of double
	public static double sqrt(double n) {
		if(n<0) throw new IllegalArgumentException("It cannot except a negative number");
		double x = 1;
		double y = 1;
		//newton formula
		while(absValue(n - (x * x)) > .005) {
			y = x;
			x = (n/y + y)/2;
		}
		return round2(x);
	}
	//Finds root of a quadratic equation with the quadratic formula
	public static String quadForm(int a, int b, int c) {
		//cast double a,b,c
		double a1 = (double)a;
		double b1 = (double)b;
		double c1 = (double)c;
		//finds that if the discriminant is a negative number, there are no real roots
		if(discriminant(a1, b1, c1)<0){
			return "no real roots";
		}
		//find roots
		double root1 = ((-b1 + sqrt(discriminant(a1,b1,c1)))/(2*a1));
		double root2 = ((-b1 - sqrt(discriminant(a1,b1,c1)))/(2*a1));
		root1 = round2(root1);
		root2 = round2(root2);
		//find greater and lesser root of the two and make String
		double firstRoot = max(root1, root2);
		String secondRoot = "" + (root1+root2-firstRoot);  
		String firstRoot1 = "" + firstRoot;
		return firstRoot1 + " and " + secondRoot;
	}

}
