/* Mandy Woo
 * September 6, 2017
 * This is the runner for the calculate library. It is used to test the methods in Calculate.
 */
public class DoMath {

	public static void main(String[] args) {
		System.out.println(Calculate.square(-7));
		System.out.println(Calculate.cube(-1));
		System.out.println(Calculate.average(-2,-2));
		System.out.println(Calculate.average(-2,-4,-6));
		System.out.println(Calculate.toDegrees(3.14159/2));
		System.out.println(Calculate.toRadians(180));
		System.out.println(Calculate.discriminant(1,1,1));
		System.out.println(Calculate.toImproperFrac(-3,1,2));
		System.out.println(Calculate.toMixedNum(7,2));
		System.out.println(Calculate.foil(2,3,6,-7,"n"));
		System.out.println(Calculate.isDivisibleBy(-14,8));
		System.out.println(Calculate.absValue(-214));
		System.out.println(Calculate.max(-214,5));
		System.out.println(Calculate.max(-214,5,100));
		System.out.println(Calculate.min(5,100));
		System.out.println(Calculate.round2(5.5));
		System.out.println(Calculate.exponent(2,3));
		System.out.println(Calculate.factorial(1));
		System.out.println(Calculate.isPrime(3));
		System.out.println(Calculate.gcf(11, 25));
		System.out.println(Calculate.sqrt(56));
		System.out.println(Calculate.quadForm(-1,1,4));
		
		
	}
}
