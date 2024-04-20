package parsing.sample.tokenization;

public class SampleTokenizer {

    //save text
    private String _buffer;
    //save token extracted from next()
    private SampleToken currentToken;

    public SampleTokenizer(String text) {
        _buffer = text;
        next();
    }


    public boolean hasNext() {
        return currentToken != null;
    }

    public SampleToken current() {
        return currentToken;
    }

    public void next() {

        // pre-check
        _buffer = _buffer.trim();
        if(_buffer.isEmpty()) {
            currentToken = null;
            return;
        }

        // tokenization process
        if (_buffer.charAt(0) == '+') {
            currentToken = new SampleToken("+", SampleToken.Type.ADD);
        } else if (_buffer.charAt(0) == '*') {
            currentToken = new SampleToken("*", SampleToken.Type.MUL);
        } else {
            int i = 1;
            while (i < _buffer.length()) {
                if (!Character.isDigit(_buffer.charAt(i))) {
                    break;
                }
                ++i;
            }
            currentToken = new SampleToken(_buffer.substring(0, i), SampleToken.Type.INT);
        }

        // Remove the extracted token from buffer
        int tokenLen = currentToken.token().length();
        _buffer = _buffer.substring(tokenLen);
    }
}
