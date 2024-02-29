package umlpatterndesign.p3;

public class Customer {
    Employee[] employees;

    Employee[] getEmployees() {
        return employees;
    }

    void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    void complainEmployees() {
        for (int i = 0; i < employees.length; ++i) {
            System.out.println("complain the employee: " + i + " to " + employees[i].employer);
        }
    }
}
