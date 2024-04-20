package parsing.sample.parser;


public class SampleAddExp extends SampleExp {
    private SampleExp factorExp;
    private SampleExp exp;

    public SampleAddExp(SampleExp factorExp, SampleExp exp) {
        this.factorExp = factorExp;
        this.exp = exp;
    }

    @Override
    public String show() {
        return "(" + factorExp.show() + " + " + exp.show() + ")";
    }

    @Override
    public int evaluate() {
        return (factorExp.evaluate() + exp.evaluate());
    }
}
