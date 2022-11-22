package internal.models;

public class Manager extends Employee {
    public Manager(String fullName, Integer salary) {
        super(fullName, salary);
    }

    @Override
    public void doWork() {
        System.out.printf("%s managing...\n", fullName);
    }

}
