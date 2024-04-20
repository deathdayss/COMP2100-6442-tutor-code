package parsing.sample.parser;


public class SampleMulExp extends SampleExp {
    private SampleExp intExp;
    private SampleExp exp;

    public SampleMulExp(SampleExp intExp, SampleExp exp) {
        this.intExp = intExp;
        this.exp = exp;
    }

    @Override
    public String show() {
        return "(" + intExp.show() + " * " + exp.show() + ")";
    }

    @Override
    public int evaluate() {
        return (intExp.evaluate() * exp.evaluate());
    }
}
