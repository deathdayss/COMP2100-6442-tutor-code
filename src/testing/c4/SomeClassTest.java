package testing.c4;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Optional;

public class SomeClassTest {

	@Test
	public void test() {
		SomeClass.someMethod(true, true, true);
		assertEquals( true, SomeClass.someMethod(true, true, true));
		
	}

	@Test
	public void test2() {
		assertEquals(Optional.of(1), new Integer(1));
	}

}
