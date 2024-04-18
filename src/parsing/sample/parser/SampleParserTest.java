package parsing.sample.parser;

import org.junit.Test;
import parsing.sample.tokenization.SampleTokenizer;

import static org.junit.Assert.assertEquals;

public class SampleParserTest {
    private static SampleTokenizer tokenizer;

    private static final String SIMPLECASE = "5";
    private static final String MIDCASE = "2 + 7";
    private static final String COMPLEXCASE = "111 + 231 + 123124";

    @Test(timeout=1000)
    public void testSimleAdd() {
        SampleTokenizer mathTokenizer = new SampleTokenizer(SIMPLECASE);
        SampleExp t1 = new SampleParser(mathTokenizer).parseExp();
        assertEquals(5, t1.evaluate());
    }

    @Test(timeout=1000)
    public void testMidAdd() {
        SampleTokenizer mathTokenizer = new SampleTokenizer(MIDCASE);
        SampleExp t2 = new SampleParser(mathTokenizer).parseExp();
        assertEquals(9, t2.evaluate());
    }

    @Test(timeout=1000)
    public void testComplexAdd() {
        SampleTokenizer mathTokenizer = new SampleTokenizer(COMPLEXCASE);
        SampleExp t3 = new SampleParser(mathTokenizer).parseExp();
        assertEquals(123466, t3.evaluate());
    }
}
