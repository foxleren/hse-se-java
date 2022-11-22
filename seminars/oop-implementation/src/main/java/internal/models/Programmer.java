package internal.models;

import internal.interfaces.Gradable;

public class Programmer extends Employee implements Gradable {
    public Programmer(String fullName, Integer salary) {
        super(fullName, salary);
    }

    @Override
    public void doWork() {
        System.out.printf("%s coding...\n", fullName);
    }

    public void IncreaseSalary() {
        salary *= 2;
    }
}
