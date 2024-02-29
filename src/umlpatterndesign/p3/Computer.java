package umlpatterndesign.p3;

public class Computer {
    Cpu cpu;
    Computer() {
        System.out.println("produce a computer");
        this.cpu = new Cpu(this);
        costMoney();
    }

    private void costMoney() {
        System.out.println("cost money");
    }
}
