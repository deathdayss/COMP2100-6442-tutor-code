package week1.p3;

public class ComputerProducer extends Employee {

    @Override
    protected void serveMyCustomers() {
        super.serveMyCustomers();
        produceComputer();
    }

    Computer produceComputer() {
        return new Computer();
    }
}
