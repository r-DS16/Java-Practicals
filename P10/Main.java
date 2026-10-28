import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

interface Borrowable { void borrow(); }

abstract class LibraryItem {
    private final String id;
    private final String title;
    LibraryItem(String id, String title) { this.id = id; this.title = title; }
    String getId() { return id; }
    String getTitle() { return title; }
    abstract String category();
}

class Book extends LibraryItem implements Borrowable {
    private final String author;
    private boolean borrowed;
    Book(String id, String title, String author) { super(id, title); this.author = author; }
    @Override String category() { return "Book"; }
    @Override public void borrow() { borrowed = true; }
    public String toString() { return category() + "[" + getId() + ", " + getTitle() + ", " + author + ", borrowed=" + borrowed + "]"; }
}

class GenericRepository<T extends LibraryItem> {
    private final List<T> items = new ArrayList<>();
    void add(T item) { items.add(item); }
    T findById(String id) {
        for (T item : items) if (item.getId().equals(id)) return item;
        return null;
    }
    int size() { return items.size(); }
    public String toString() { return items.toString(); }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("P10 - Integrated Library Design");
        GenericRepository<Book> repository = new GenericRepository<>();
        Book book1 = new Book("B101", "Clean Code", "Robert Martin");
        Book book2 = new Book("B102", "Effective Java", "Joshua Bloch");
        repository.add(book1); repository.add(book2);
        System.out.println("Repository size: " + repository.size());
        Book requested = repository.findById("B102");
        if (requested != null) { requested.borrow(); System.out.println("Borrowed: " + requested); }

        Queue<String> requests = new ArrayDeque<>(); // queue ADT and composition
        requests.offer("B101"); requests.offer("B102");
        System.out.println("Next request: " + requests.poll());
        System.out.println("Remaining requests: " + requests);
        System.out.println("Uses encapsulation, inheritance, abstraction, polymorphism, interfaces, composition, generics, and a queue.");
    }
}
