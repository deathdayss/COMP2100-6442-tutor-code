package testing.p1;
import static org.junit.Assert.*;
/*
* don't look at the actual code of Fruitcalculator class. Write the test method based on the description.
* You need to write some test methods to test two static methods of Fruitcalculator class: fruitStringToInt and addFruit.
* The relationship between the string and int is: "apple" -> 1, "banana" -> 3, "peach" -> 10, other string -> 0.
* fruitStringToInt takes one string as its input, return one int as its output. Only lowercase is allowed for the fruit names.
* addFruit takes two string and return the sum of the two strings based on the relationship between the string and the int above.
* */

import org.junit.Test;

public class FruitCalculatorTest {
    @Test
    public void sampleTest() {
        assertEquals(1, FruitCalculator.fruitStringToInt("apple"));
    }
}
