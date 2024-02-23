package week1.p2;

public abstract class Computer implements Calculator {
    public String cpuName;
    double cpuClockRate;
    private int cpuCoreNumber;

    @Override
    public double calculateLength() {
        System.out.println("calculate length - 1");
        return 1;
    }

    @Override
    public void saveResult(String data) {
        System.out.println("save result - 1");
        return;
    }

    protected void setUpComputer() {
        System.out.println("set up computer");
    }

    void destroyComputer() {
        System.out.println("destroy computer");
    }
}