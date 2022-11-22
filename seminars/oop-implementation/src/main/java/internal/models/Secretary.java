package internal.models;

public class Secretary extends Employee {
    public Secretary(String fullName, Integer salary) {
        super(fullName, salary);
    }

    @Override
    public void doWork() {
        System.out.printf("%s doing secretary work...\n", fullName);
    }
}
