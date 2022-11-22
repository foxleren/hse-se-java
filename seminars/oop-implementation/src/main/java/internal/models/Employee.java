package internal.models;

public abstract class Employee {
    protected String fullName;
    protected Integer salary;

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Employee(String fullName, Integer salary) {
        this.fullName = fullName;
        this.salary = salary;
    }

    public abstract void doWork();

    @Override
    public String toString() {
        return String.format("%s | Role: %s", fullName, this.getClass().getSimpleName());
    }
}
