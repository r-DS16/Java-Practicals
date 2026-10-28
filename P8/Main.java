class IntStack {
    private final int[] data;
    private int top = -1;
    IntStack(int capacity) { data = new int[capacity]; }
    void push(int value) {
        if (top == data.length - 1) throw new IllegalStateException("Stack overflow");
        data[++top] = value;
    }
    int pop() {
        if (isEmpty()) throw new IllegalStateException("Stack underflow");
        return data[top--];
    }
    int peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return data[top];
    }
    boolean isEmpty() { return top == -1; }
}

class IntQueue {
    private final int[] data;
    private int front = 0, rear = -1, size = 0;
    IntQueue(int capacity) { data = new int[capacity]; }
    void enqueue(int value) {
        if (size == data.length) throw new IllegalStateException("Queue overflow");
        rear = (rear + 1) % data.length; data[rear] = value; size++;
    }
    int dequeue() {
        if (size == 0) throw new IllegalStateException("Queue underflow");
        int value = data[front]; front = (front + 1) % data.length; size--; return value;
    }
    int front() {
        if (size == 0) throw new IllegalStateException("Queue is empty");
        return data[front];
    }
    boolean isEmpty() { return size == 0; }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("P8 - Stack and Queue ADTs");
        IntStack stack = new IntStack(3);
        stack.push(10); stack.push(20); stack.push(30);
        System.out.println("Stack peek: " + stack.peek() + ", pop: " + stack.pop());
        try { stack.push(40); stack.push(50); }
        catch (IllegalStateException e) { System.out.println("Stack handling: " + e.getMessage()); }

        IntQueue queue = new IntQueue(3);
        queue.enqueue(1); queue.enqueue(2); queue.enqueue(3);
        System.out.println("Queue front: " + queue.front() + ", dequeue: " + queue.dequeue());
        queue.enqueue(4);
        while (!queue.isEmpty()) System.out.println("Dequeued: " + queue.dequeue());
        try { queue.dequeue(); }
        catch (IllegalStateException e) { System.out.println("Queue handling: " + e.getMessage()); }
    }
}
