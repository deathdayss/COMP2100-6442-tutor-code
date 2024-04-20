package parsing.sample.parser;

import parsing.sample.tokenization.SampleTokenizer;

// <exp> -> <factor> + <exp> | <factor>
// <factor> -> <int> * <exp> | <int>
public class SampleParser {
    SampleTokenizer _tokenizer;

    public SampleParser(SampleTokenizer tokenizer) {
        _tokenizer = tokenizer;
    }

    public SampleExp parseExp() {
        SampleExp factorExp = parseFactor();
        if (!_tokenizer.hasNext()) {
            return factorExp;
        }
        if (_tokenizer.current().token().equals("+")) {
            _tokenizer.next();
            SampleExp exp = parseExp();
            return new SampleAddExp(factorExp, exp);
        }
        return factorExp;
    }

    public SampleExp parseFactor() {
        SampleExp intExp = new SampleIntExp(Integer.parseInt(_tokenizer.current().token()));
        _tokenizer.next();
        if (!_tokenizer.hasNext()) {
            return intExp;
        }
        if (_tokenizer.current().token().equals("*")) {
            _tokenizer.next();
            SampleExp exp = parseExp();
            System.out.println("MUL: " + intExp.show() + "--" + exp.show());
            return new SampleMulExp(intExp, exp);
        }
        return intExp;
    }
}
