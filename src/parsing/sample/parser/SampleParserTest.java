package parsing.sample.parser;

import org.junit.Test;
import parsing.sample.tokenization.SampleTokenizer;

import static org.junit.Assert.assertEquals;

public class SampleParserTest {
    private static SampleTokenizer tokenizer;

    private static final String SIMPLEADDCASE = "5";
    private static final String MIDADDCASE = "2 + 7";
    private static final String COMPLEXADDCASE = "111 + 231 + 123124";
    private static final String SIMPLEMULCASE = "2 * 3";
    private static final String MIDMULCASE = "3 * 7 * 5";
    private static final String ULTIMATECASE = "523 + 3 * 7 * 5 + 52 * 2 + 2 * 3";

    @Test(timeout=1000)
    public void testSimpleAdd() {
        SampleTokenizer mathTokenizer = new SampleTokenizer(SIMPLEADDCASE);
        SampleExp t1 = new SampleParser(mathTokenizer).parseExp();
        assertEquals(5, t1.evaluate());
    }

    @Test(timeout=1000)
    public void testMidAdd() {
        SampleTokenizer mathTokenizer = new SampleTokenizer(MIDADDCASE);
        SampleExp t2 = new SampleParser(mathTokenizer).parseExp();
        assertEquals(9, t2.evaluate());
    }

    @Test(timeout=1000)
    public void testComplexAdd() {
        SampleTokenizer mathTokenizer = new SampleTokenizer(COMPLEXADDCASE);
        SampleExp t3 = new SampleParser(mathTokenizer).parseExp();
        assertEquals(123466, t3.evaluate());
    }

    @Test(timeout=1000)
    public void testSimpleMul() {
        SampleTokenizer mathTokenizer = new SampleTokenizer(SIMPLEMULCASE);
        SampleExp t4 = new SampleParser(mathTokenizer).parseExp();
        assertEquals(6, t4.evaluate());
    }

    @Test(timeout=1000)
    public void testMidMul() {
        SampleTokenizer mathTokenizer = new SampleTokenizer(MIDMULCASE);
        SampleExp t6 = new SampleParser(mathTokenizer).parseExp();
        assertEquals(105, t6.evaluate());
    }

    @Test(timeout=1000)
    public void testUltimate() {
        SampleTokenizer mathTokenizer = new SampleTokenizer(ULTIMATECASE);
        SampleExp t7 = new SampleParser(mathTokenizer).parseExp();
        assertEquals(738, t7.evaluate());
    }
}
