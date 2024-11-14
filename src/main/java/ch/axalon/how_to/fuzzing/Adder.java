package ch.axalon.how_to.fuzzing;

/**
 * This class contains a sample implementation that we use to illustrate fuzzing. <br>
 * The add method contains a bug that it does not throw the ArithmeticException when it should.
 * 
 *
 */
public class Adder {

	public static void main(String[] args) {
		System.out.println("5 + 10 = " + add(5, 10));
		// this is expected to throw, but it doesn't
		System.out.println("Integer.MAX_VALUE + 1 = " + add(Integer.MAX_VALUE, 1));
	}

	/**
	 * Adding two integers. If the sum overflows the integer the function should throw an exception.
	 * 
	 * @param a
	 * @param b
	 * @return the sum
	 * @throws ArithmeticException if the sum overflows the int range
	 */
	public static int add(int a, int b) throws ArithmeticException {
		// that would be the correct implementation
		// return Math.addExact(a, b);

		// this might however overflow
		return a + b;
	}
}
