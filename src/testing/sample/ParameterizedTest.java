package testing.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTest {
    @Parameters
    public static Object[] oneDimensionalData() {
        return new Object[] {1,2,3};
    }

//    @Parameters
//    public static Object[][] twoDimensionalData() {
//        return new Object[][] {{"a", "b", "c"}, {"d", "e", "f"}};
//    }

    @Parameter
    public int number;

//    @Parameter(0)
//    public String s1;
//
//    @Parameter(1)
//    public String s2;
//
//    @Parameter(2)
//    public String s3;

    @Test
    public void testOneDimensionalData() {
        assertEquals(1, number);
    }

//    @Test
//    public void testTwoDimensionalData() {
//        assertEquals("a", s1);
//    }
}
