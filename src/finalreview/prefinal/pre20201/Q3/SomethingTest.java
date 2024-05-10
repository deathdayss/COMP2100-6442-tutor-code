package finalreview.prefinal.pre20201.Q3;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * You are given a java class called Something, which has a method called
 * someMethod. Please implement a minimum number of test cases for testing `someMethod`
 * that are branch complete within `someMethod`. Write your test case(s) in test() method in
 * `SomethingTest.java`. You are not allowed to alter the signatures of the given
 * methods and the package structures of the given classes. Please upload the
 * `SomethingTest.java` file to Wattle for marking.
 *
 *
 * @author nanwang
 *
 */
public class SomethingTest {

	@Test
	public void test() {
		// Implement your test cases
		// START YOUR CODE

		// n1 > n2, method2(n1, n2) == 36, n1 > n3, n2 < n4, method3(n1, n3) == method3(n2, n4), n3 < n4, method1(n3, n4) != 15
		assertEquals(252, Something.someMethod(72, 36, 36, 72));
		// n1 > n2, method2(n1, n2) == 36, n1 < n3, n2 > n4, method3(n1, n3) != method3(n2, n4), n3 > n4, method1(n3, n4) != 15
		assertEquals(108, Something.someMethod(72, 36, 100, 4));
		// n1 < n2, method2(n1, n2) != 36, method1(n3, n4) == 15
		assertEquals(47, Something.someMethod(36, 73, 31, 16));

		// END YOUR CODE
	}
}
