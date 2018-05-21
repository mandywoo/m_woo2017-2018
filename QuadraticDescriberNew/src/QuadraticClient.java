
/*Mandy Woo
 * 
 * Pseudocode
 * QuadraticClient:
 * Import Declaration before header
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
 * standard form method
 * direction it open: check if a is negative or positive
 * axis of symmetry: complete the square
 * vertex: complete the square
 * x - intercept(s): quadForm method, then calculate 
 * y- intercept: c
 * add all to String
 * return String
 */


import java.util.*;
public class QuadraticClient {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		boolean finished = false;
		while (!finished) {
			System.out.println("Provide values for coefficients a, b, and c.");
			System.out.println("a: ");
			double a = userInput.nextDouble();
			System.out.println("b: ");
			double b = userInput.nextDouble();
			System.out.println("c: ");
			double c = userInput.nextDouble();
			String quadInfo = Quadratic.quadrDescriber(a, b, c);
			System.out.println(quadInfo);

			System.out.println("Do you want to keep going? (Type \"quit\" to end)");
			String quit = userInput.next();
			if (quit.charAt(0)==('q')) {
				finished = true;
			}

		}
	}

}
