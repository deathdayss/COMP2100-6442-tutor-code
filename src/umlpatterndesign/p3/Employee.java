package umlpatterndesign.p3;

public abstract class Employee {
    public Employer employer;
    protected Customer[] myCustomers;

    public Customer[] getMyCustomers() {
        return myCustomers;
    }

    public void setMyCustomers(Customer[] myCustomers) {
        this.myCustomers = myCustomers;
    }

    void serveMyCustomers() {
        System.out.println("serve my customer");
    }

    private void changeEmployer(Employer employer) {
        this.employer = employer;
    }
}
