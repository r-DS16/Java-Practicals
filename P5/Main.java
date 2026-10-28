import java.util.ArrayList;
import java.util.List;

class Course {
    private final String code;
    Course(String code) { this.code = code; }
    public String toString() { return code; }
}

class Teacher {
    private final String name;
    Teacher(String name) { this.name = name; }
    public String toString() { return name; }
}

class Department {
    private final String name;
    private final List<Teacher> teachers = new ArrayList<>(); // composition
    Department(String name) { this.name = name; }
    void addTeacher(String name) { teachers.add(new Teacher(name)); }
    public String toString() { return name + " teachers=" + teachers; }
}

class College {
    private final String name;
    private final List<Department> departments = new ArrayList<>(); // aggregation
    College(String name) { this.name = name; }
    void addDepartment(Department department) { departments.add(department); }
    public String toString() { return name + " departments=" + departments; }
}

class Student {
    private final String name;
    private final List<Course> courses = new ArrayList<>();
    Student(String name) { this.name = name; }
    void enroll(Course course) { courses.add(course); } // association
    void showCourses() { System.out.println(name + " enrolled in " + courses); }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("P5 - Object Relationships");
        College college = new College("Central College");
        Department department = new Department("Computer Applications");
        department.addTeacher("Prof. Sharma");
        department.addTeacher("Prof. Das");
        college.addDepartment(department);
        Student student = new Student("Neha");
        student.enroll(new Course("JAVA-301"));
        student.enroll(new Course("DS-302"));
        System.out.println(college);
        student.showCourses();
        System.out.println("Department owns its teachers (composition), college groups departments (aggregation), and student-course is association.");
    }
}
