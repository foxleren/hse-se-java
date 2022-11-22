package internal.models;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Company(List<Employee> employees) {
        this.employees = employees;
    }

    public void printAllEmployees() {
        for (var e : employees) {
            System.out.println(e);
        }
    }

    public void doEmployeesWork() {
        for (var e : employees) {
            e.doWork();
        }
    }

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public void getSalaries() {
        for (var e : employees) {
            System.out.printf("%s gets %s Rubles\n", e, e.salary);
        }
    }

    public void increaseProgrammersSalaries() {
        for (var e : employees) {
            if (e instanceof Programmer p) {
                p.IncreaseSalary();
            }
        }
    }
}
