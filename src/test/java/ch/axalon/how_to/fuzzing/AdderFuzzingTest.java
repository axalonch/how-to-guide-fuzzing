package ch.axalon.how_to.fuzzing;

import org.junit.jupiter.api.Assertions;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

public class AdderFuzzingTest {

	/**
	 * This is a fuzzing target that fuzzes the sample implementation.
	 * 
	 * @param data the fuzzing data
	 */
	@Property
	public void fuzzAddition(@ForAll int a, @ForAll int b) {
		// 1. the first step of a fuzzing target is to derive the input parameters for the function under test
		//     some frameworks do this for you, as the one that we currently use
		
		// 2. next, the derived input parameters are used to invoke the function under test
		int sum = Adder.add(a, b);
		
		// 3. next, we calculate the sum using another method to compare the output
		int expected = Math.addExact(a, b);
		
		// 4. the last step is to compare the output of the function under test and our reference output value.
		//     note: the function might also throw, which is also a form of output
		Assertions.assertEquals(expected, sum);
	}
}
