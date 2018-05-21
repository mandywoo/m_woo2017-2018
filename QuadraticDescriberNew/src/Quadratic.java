/*Mandy Woo
 * 
 * Pseudocode
 * QuadraticClient:
 * Import Declaration before class header
 * Main Method
 * Do, while loop(not quit)
 * Initialize scanner
 * Take in input values(a,b,c) for quadratic formula
 * Put input values in quadrDesciber method
 * Print output
 * Prompt: Do you want to keep going? (Type "quit" to end)
 * 
 * Quadratic:
 * main method
 * quadrDescriber method
 * Print: Description of the graph of:
 * standard form method
 * 
 * direction it opens: check if a is negative or positive
 * axis of symmetry: complete the square
 * vertex: complete the square
 * x - intercept(s): quadForm method, then calculate 
 * y- intercept: c
 * add all to String
 * return String
 */


public class Quadratic {
	public static String quadrDescriber (double a, double b, double c) {
		//print standard form
		System.out.println("Description of the graph of:");
		String standardForm = a + "x^2 + " + b + "x + " + c;
		System.out.println(standardForm);
		
		//check direction graph opens
		String opens = "Opens: ";
		if(a>0) {
			opens += "Up";
		}else if(a<0) {
			opens += "Down";
		}
			
		//axis of symmetry
		double symmetry = -b/2*a;
		String axisOfSym = "Axis of Symmetry: ";
		axisOfSym += symmetry;
		
		//vertex
		String vertex = "Vertex: (" + symmetry + ", ";
		//plug x value into equation to find y
		vertex += (a*square(symmetry) + b*symmetry + c);
		vertex += (")");
		
		//x-intercepts
		String xIntercept = "x-intercept(s): ";
		xIntercept += quadForm(a, b, c);
		
		//y-intercepts
		String yIntercept = "y-intercept: ";
		yIntercept += c;
		
					
		//Store info in return String
		String str = opens + "\n" + axisOfSym + "\n" + vertex + "\n" + xIntercept +
				"\n" + yIntercept + "\n";
		return str;
	}
		
	
	//methods used above copied and adjusted from calculate
	public static String quadForm(double a, double b, double c) {
		//finds that if the discriminant is a negative number, there are no real roots
		if(discriminant(a, b, c)<0){
			return "none";
		}
		//find roots
		double root1 = ((-b + sqrt(discriminant(a,b,c)))/(2*a));
		double root2 = ((-b - sqrt(discriminant(a,b,c)))/(2*a));
		root1 = round2(root1);
		root2 = round2(root2);

		//find greater and lesser root of the two
		double firstRoot = max(root1, root2);
		String secondRoot = "" + (root1+root2-firstRoot);  
		String firstRoot1 = "" + firstRoot;
		return firstRoot1 + " and " + secondRoot;
	}
	public static double discriminant(double a, double b, double c) {
		return b*b-4*a*c;
	}
	public static double sqrt(double n) {
		if(n<0) throw new IllegalArgumentException("It cannot except a negative number");
		double x = 1;
		double y = 1;
		while(absValue(n - (x * x)) > .005) {
			y = x;
			x = (n/y + y)/2;
		}
		return round2(x);
	}
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
		result = tempInt / 100.0;
		return result;
	}
	public static double max(double num1, double num2) {
		if(num1>num2) {
			return num1;
		}else{
			return num2;
		}
	}
	public static double absValue(double number) {
		if(number<0) {
			return number*-1;
		}else {
			return number;
		}
	}
	public static double square(double operand) {
		return operand*operand;
	}
}

