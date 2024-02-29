package umlpatterndesign.p3;

public class Employer {
    Employee[] employees;
    private String name;

    private void recruitEmployees(Employee[] employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "name='" + name + '\'' +
                '}';
    }
}
