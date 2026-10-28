class Person {
    protected String name;

    Person(String name) {
        this.name = name;
        System.out.println("Person constructor called");
    }

    void introduce() { System.out.println("Person: " + name); }
}

class Student extends Person {
    private int rollNo;

    Student(String name, int rollNo) {
        super(name);
        this.rollNo = rollNo;
        System.out.println("Student constructor called");
    }

    @Override
    void introduce() {
        super.introduce();
        System.out.println("Student roll number: " + rollNo);
    }
}

class GraduateStudent extends Student {
    private String specialization;

    GraduateStudent(String name, int rollNo, String specialization) {
        super(name, rollNo);
        this.specialization = specialization;
        System.out.println("GraduateStudent constructor called");
    }

    @Override
    void introduce() {
        super.introduce();
        System.out.println("Specialization: " + specialization);
    }
}

class Faculty extends Person {
    private String department;

    Faculty(String name, String department) {
        super(name);
        this.department = department;
    }

    @Override
    void introduce() {
        super.introduce();
        System.out.println("Faculty department: " + department);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("P2 - Inheritance and super");
        GraduateStudent graduate = new GraduateStudent("Riya", 201, "Computer Science");
        graduate.introduce();
        System.out.println();
        Faculty faculty = new Faculty("Dr. Kumar", "MCA");
        faculty.introduce();
    }
}
