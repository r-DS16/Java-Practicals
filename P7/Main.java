import java.util.ArrayList;
import java.util.List;

class Box<T> {
    private T value;
    void set(T value) { this.value = value; }
    T get() { return value; }
    public String toString() { return String.valueOf(value); }
}

public class Main {
    static <T> void display(T value) { System.out.println("Generic method: " + value + " (" + value.getClass().getSimpleName() + ")"); }

    static double sumNumbers(List<? extends Number> numbers) {
        double total = 0;
        for (Number number : numbers) total += number.doubleValue();
        return total;
    }

    static void addIntegers(List<? super Integer> destination) {
        destination.add(10);
        destination.add(20);
    }

    public static void main(String[] args) {
        System.out.println("P7 - Generics");
        Box<String> textBox = new Box<>();
        Box<Integer> numberBox = new Box<>();
        textBox.set("Type safe Java");
        numberBox.set(2026);
        System.out.println("String box: " + textBox);
        System.out.println("Integer box: " + numberBox);
        display(3.14);
        display("Generic programming");
        List<Double> values = List.of(2.5, 4.5, 3.0);
        System.out.println("Sum (? extends Number): " + sumNumbers(values));
        List<Number> destination = new ArrayList<>();
        addIntegers(destination);
        System.out.println("Values added (? super Integer): " + destination);
    }
}
