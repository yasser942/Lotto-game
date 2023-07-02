public class Queue {
    private int rear, front;
    private Object[] elements;

    Queue(int capacity) {
        elements = new Object[capacity];
        rear = -1;
        front = 0;
    }

    void enqueue(Object data) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            rear++;
            elements[rear] = data;
        }

    }

    Object dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            Object data = elements[front];
            elements[front] = null;
            front++;
            return data;
        }
    }

    Object peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            return elements[front];
        }
    }

    int size() {
        return rear - front + 1;
    }

    boolean isFull() {
        return (rear + 1 == elements.length);
    }

    boolean isEmpty() {
        return rear < front;
    }

}
