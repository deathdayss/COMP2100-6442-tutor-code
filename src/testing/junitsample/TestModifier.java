package testing.junitsample;

import org.junit.Test;

public class TestModifier {
    @Test(expected = NumberFormatException.class)
    public void testExceptionPass() {
        System.out.println("testExceptionPass: do something wrong");
        Double.parseDouble("awe23");
    }

    @Test(expected = NumberFormatException.class)
    public void testExecptionFail() {
        System.out.println("testExceptionFail: do nothing");
    }

    @Test(timeout = 1000)
    public void testTimeoutPass() {
        System.out.println("testTimeoutPass: do nothing");
    }

    @Test(timeout = 1000)
    public void testTimeoutFail() {
        System.out.println("testTimeoutFail: infinite loop");
        int i = 0;
        while (true) {
            i++;
        }
    }
}
