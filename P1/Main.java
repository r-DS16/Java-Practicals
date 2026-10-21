/*Practical 1: Classes, Objects, Encapsulation, and Constructors Create a Java program for a Student or BankAccount class. 
Use private data members, public methods, default and parameterized constructors, constructor overloading, getters/setters, 
and validation to demonstrate encapsulation and object creation.*/

//Solution:-
// Student.java
class Student {
    // 1. Private data members (Encapsulation)
    private int rollNo;
    private String name;
    private double marks;

    // 2. Default Constructor
    public Student() {
        this.rollNo = 0;
        this.name = "Unknown";
        this.marks = 0.0;
    }

    // 3. Parameterized Constructor (Constructor Overloading)
    public Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        setMarks(marks); // Uses setter for validation
    }

    // 4. Overloaded Constructor (2 parameters)
    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = 0.0;
    }

    // 5. Getters and Setters with Validation
    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        // Validation: marks must be between 0 and 100
        if (marks >= 0.0 && marks <= 100.0) {
            this.marks = marks;
        } else {
            System.out.println("Invalid marks (" + marks + ")! Must be between 0 and 100.");
        }
    }

    // 6. Public display method
    public void display() {
        System.out.println("Roll No: " + rollNo + " | Name: " + name + " | Marks: " + marks);
    }
}

// Driver class to demonstrate object creation and operations
public class Main {
    public static void main(String[] args) {
        // Object 1: Default constructor
        Student s1 = new Student();
        System.out.print("s1 (Default): ");
        s1.display();

        // Object 2: Parameterized constructor
        Student s2 = new Student(101, "Rahul", 88.5);
        System.out.print("s2 (Parameterized): ");
        s2.display();

        // Object 3: Overloaded constructor (rollNo + name)
        Student s3 = new Student(102, "Priya");
        System.out.print("s3 (2-Param): ");
        s3.display();

        // Demonstrating Validation via Setter
        System.out.println("\n--- Testing Setter & Validation on s3 ---");
        s3.setMarks(95.0);   // Valid update
        s3.setMarks(150.0);  // Invalid update (triggers validation)

        System.out.print("s3 after update: ");
        s3.display();
    }
}
