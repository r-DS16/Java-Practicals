class GenericList<T> {
    private static class Node<T> {
        T value; Node<T> next;
        Node(T value) { this.value = value; }
    }
    private Node<T> head;
    private int size;

    void add(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) head = node;
        else { Node<T> current = head; while (current.next != null) current = current.next; current.next = node; }
        size++;
    }

    boolean remove(T value) {
        Node<T> previous = null, current = head;
        while (current != null) {
            if (java.util.Objects.equals(current.value, value)) {
                if (previous == null) head = current.next; else previous.next = current.next;
                size--; return true;
            }
            previous = current; current = current.next;
        }
        return false;
    }

    boolean contains(T value) {
        Node<T> current = head;
        while (current != null) { if (java.util.Objects.equals(current.value, value)) return true; current = current.next; }
        return false;
    }

    int size() { return size; }
    boolean isEmpty() { return size == 0; }
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) { result.append(current.value); if (current.next != null) result.append(", "); current = current.next; }
        return result.append("]").toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("P9 - Generic Linked List ADT");
        GenericList<String> names = new GenericList<>();
        names.add("Asha"); names.add("Bharat"); names.add("Charu");
        System.out.println("Names: " + names + " | contains Bharat: " + names.contains("Bharat"));
        names.remove("Bharat");
        System.out.println("After deletion: " + names + " | size: " + names.size());

        GenericList<Integer> marks = new GenericList<>();
        marks.add(88); marks.add(91); marks.add(76);
        System.out.println("Integer list: " + marks + " | empty: " + marks.isEmpty());
    }
}
