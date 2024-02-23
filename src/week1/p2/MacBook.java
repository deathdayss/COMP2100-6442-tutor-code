package p2;

public class MacBook extends Computer {
    public String macBookModel;
    private String macBookCode;

    @Override
    public double calculateArea() {
        System.out.println("calculate area");
        return 3;
    }

    @Override
    public double calculateLength() {
        return super.calculateLength();
    }

    @Override
    public void loadResult() {
        System.out.println("load result");
    }

    @Override
    public void saveResult() {
        System.out.println("save result - 1");
    }

    @Override
    public void setUpComputer() {
        System.out.println("set up computer");
    }

    @Override
    protected void destroyComputer() {
        super.destroyComputer();
    }
}
