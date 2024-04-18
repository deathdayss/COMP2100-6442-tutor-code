package parsing.sample.parser;

public class SampleIntExp extends SampleExp {

    private Integer value;

    public SampleIntExp(Integer value) {
        this.value = value;
    }

    @Override
    public String show() {
        return value.toString();
    }

    @Override
    public int evaluate() {
        return value;
    }
}
