package parsing.sample.tokenization;


public class SampleToken {
    public enum Type {INT, ADD};
    private String _token = "";
    private Type _type = Type.INT;

    public SampleToken(String token, Type type) {
        _token = token;
        _type = type;
    }

    public String token() {
        return _token;
    }

    public Type type() {
        return _type;
    }
}
