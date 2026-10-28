interface Payable {
    double calculatePay();
}

interface Printable {
    void printDetails();
}

abstract class Employee {
    protected String name;
    protected double baseSalary;

    Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    abstract double calculateSalary();

    void showRole() { System.out.println("Employee: " + name); }
}

class FullTimeEmployee extends Employee implements Payable, Printable {
    FullTimeEmployee(String name, double salary) { super(name, salary); }
    @Override double calculateSalary() { return baseSalary + 5000; }
    @Override public double calculatePay() { return calculateSalary(); }
    @Override public void printDetails() {
        System.out.printf("Full-time %s -> salary: %.2f%n", name, calculateSalary());
    }
}

class ContractEmployee extends Employee implements Payable, Printable {
    private int hours;
    ContractEmployee(String name, double hourlyRate, int hours) {
        super(name, hourlyRate); this.hours = hours;
    }
    @Override double calculateSalary() { return baseSalary * hours; }
    @Override public double calculatePay() { return calculateSalary(); }
    @Override public void printDetails() {
        System.out.printf("Contract %s -> salary: %.2f%n", name, calculateSalary());
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("P4 - Abstraction and Interfaces");
        Employee[] employees = { new FullTimeEmployee("Anita", 60000), new ContractEmployee("Vikram", 450, 80) };
        for (Employee employee : employees) {
            employee.showRole();
            ((Printable) employee).printDetails();
            System.out.printf("Payable amount: %.2f%n", ((Payable) employee).calculatePay());
        }
    }
}
