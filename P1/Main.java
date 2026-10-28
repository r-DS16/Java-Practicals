class Student {
    private int rollNo;
    private String name;
    private double marks;

    public Student() {
        this(0, "Unknown", 0.0);
    }

    public Student(int rollNo, String name) {
        this(rollNo, name, 0.0);
    }

    public Student(int rollNo, String name, double marks) {
        setRollNo(rollNo);
        setName(name);
        setMarks(marks);
    }

    public int getRollNo() { return rollNo; }
    public void setRollNo(int rollNo) {
        if (rollNo < 0) throw new IllegalArgumentException("Roll number cannot be negative");
        this.rollNo = rollNo;
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    public double getMarks() { return marks; }
    public void setMarks(double marks) {
        if (marks < 0 || marks > 100) throw new IllegalArgumentException("Marks must be between 0 and 100");
        this.marks = marks;
    }

    public void display() {
        System.out.printf("Roll No: %d | Name: %s | Marks: %.1f%n", rollNo, name, marks);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("P1 - Encapsulation and Constructors");
        Student defaultStudent = new Student();
        Student student = new Student(101, "Aarav", 88.5);
        Student overloadedStudent = new Student(102, "Meera");
        defaultStudent.display();
        student.display();
        overloadedStudent.setMarks(95.0);
        overloadedStudent.display();
        try { overloadedStudent.setMarks(120); }
        catch (IllegalArgumentException e) { System.out.println("Validation: " + e.getMessage()); }
    }
}
