public class QueueImplementation<T> implements QueueInterface<T> {

    //Each node is one element inside the queue
    //Each node has a data field, and a pointer to the next Node.
    private class Node {
        T data;
        Node next;

        //Node constructor
        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    //Attributes for the beginning and end of the single linked list queue.
    private Node head;
    private Node tail;

    //Constructor of the linked list
    public QueueImplementation() {
        head = null;
        tail = null;
    }

    //We're implementing the enqueue method from the queue interface we created.
    //If the end of the queue is not null, we assign the newNode to the pointer location of the end of the queue.
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry);
        //if the tail is not null, assign the new node to the next node.
        if (tail != null) {
            tail.next = newNode;
        }
        //if the tail is null, assign the new node.
        tail = newNode;
        // if the head is null, make the tail that we just assigned be the new head.
        if (head == null) {
            head = tail;
        }
    }

    // Remove the head from the queue and return it
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty.");
        }
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }

    // Get the head of the queue
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty.");
        }
        return head.data;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Clear the queue
    public void clear() {
        // By only setting the head and tail to null, garbage collection will automatically
        // deallocate all other elements because they are no longer being referenced anywhere
        head = null;
        tail = null;
    }
}
