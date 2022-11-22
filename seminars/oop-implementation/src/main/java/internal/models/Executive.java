package internal.models;

import java.util.ArrayList;
import java.util.List;

public class Executive extends Manager {
    List<Manager> managers;

    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }

    public Executive(String fullName, Integer salary, List<Manager> managers) {
        super(fullName, salary);
        this.managers = managers;
    }

    @Override
    public void doWork() {
        System.out.printf("%s doing executive work...\n", fullName);
    }

    @Override
    public String toString() {
        return String.format("%s | His managers: %s", fullName, managers);
    }
}
