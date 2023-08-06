import java.util.NoSuchElementException;

public class CircularDoublyLinkedList {
    private Node head;
    private int size;

    public CircularDoublyLinkedList() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;
        private Node previous;

        public Node(int value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node(int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        Node node = new Node(value);

        if (head == null) {
            head = node;
            head.next = head;
            head.previous = head;
            return;
        }

        Node tail = head.previous;
        tail.next = node;
        node.previous = tail;
        node.next = head;
        head.previous = node;

        size++;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.value + " <-> ");
            current = current.next;
        } while (current != head);
        System.out.println("HEAD");
    }

    public int delete(int value) {
        Node current = head;
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        do {
            if (current.value == value) {
                if (current == head) {
                    head = head.next;
                    head.previous = current.previous;
                } else {
                    Node prevNode = current.previous;
                    Node nextNode = current.next;

                    prevNode.next = nextNode;
                    nextNode.previous = prevNode;
                }

                size--;
                return current.value;
            }
            current = current.next;
        }while (current != head);

        throw new NoSuchElementException("Node with value " + value + " not found.");
    }

    public int getSize() {
        return size;
    }
}
