package finalreview.prefinal.pre20202.Q2;

public class SequenceGenerator {

    private static Integer ID_GENERATOR = 0;

    public Integer nextVal() {
        ID_GENERATOR++;
        return ID_GENERATOR;
    }
}
