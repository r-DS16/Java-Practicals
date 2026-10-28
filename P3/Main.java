class Printer {
    void print(int value) { System.out.println("Integer: " + value); }
    void print(String value) { System.out.println("String: " + value); }
    void print(String label, int value) { System.out.println(label + ": " + value); }
}

abstract class Shape {
    abstract double area();
    void describe() { System.out.println("This is a shape"); }
}

class Circle extends Shape {
    private final double radius;
    Circle(double radius) { this.radius = radius; }
    @Override double area() { return Math.PI * radius * radius; }
}

class Rectangle extends Shape {
    private final double length, width;
    Rectangle(double length, double width) { this.length = length; this.width = width; }
    @Override double area() { return length * width; }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("P3 - Polymorphism");
        Printer printer = new Printer();
        printer.print(42);                 // method overloading
        printer.print("Java");
        printer.print("Marks", 95);

        Shape[] shapes = { new Circle(3), new Rectangle(4, 5) };
        for (Shape shape : shapes) {       // parent reference, overridden behavior
            shape.describe();
            System.out.printf("Area: %.2f%n", shape.area());
        }
    }
}
