package app;

import internal.models.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Programmer p1 = new Programmer("Mike Down", 100000);
        Programmer p2 = new Programmer("John Wost", 80000);
        Manager m1 = new Manager("Jane Black", 60000);
        Manager m2 = new Manager("Jack Ruble", 65000);
        Executive e1 = new Executive("Luke Daniel", 90000, new ArrayList<>(Arrays.asList(m1, m2)));
        Secretary s1 = new Secretary("Kate Bronson", 40000);


        Company company = new Company(new ArrayList<>(Arrays.asList(p1, p2, m1, m2, e1, s1)));
        System.out.println("->All employees<-");
        company.printAllEmployees();
        System.out.println("->Employees work<-");
        company.doEmployeesWork();
        System.out.println("->All employees BEFORE increasing programmers' salary<-");
        company.getSalaries();
        company.increaseProgrammersSalaries();
        System.out.println("->All employees AFTER increasing programmers' salary<-");
        company.getSalaries();
    }
}