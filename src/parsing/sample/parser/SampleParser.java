package parsing.sample.parser;

import parsing.sample.tokenization.SampleTokenizer;

// EXP => INT + EXP | INT
public class SampleParser {
    SampleTokenizer _tokenizer;

    public SampleParser(SampleTokenizer tokenizer) {
        _tokenizer = tokenizer;
    }

    public SampleExp parseExp() {
        SampleExp intExp = new SampleIntExp(Integer.parseInt(_tokenizer.current().token()));
        _tokenizer.next();
        if (!_tokenizer.hasNext()) {
            return intExp;
        }
        _tokenizer.next();
        SampleExp exp = parseExp();
        return new SampleAddExp(intExp, exp);
    }
}
