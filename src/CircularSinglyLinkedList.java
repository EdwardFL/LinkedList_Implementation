import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public CircularSinglyLinkedList() {
        this.size = 0;
    }

    private class Node {
        private Node next;
        private int data;
        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.next = next;
            this.data = data;
        }
    }

    public void insert(int value) {
        Node node = new Node(value);

        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void display() {
        Node node = head;

        if (head != null) {
            do {
                System.out.print(node.data + " -> ");
                node = node.next;
            } while (node != head);
            System.out.println("HEAD");
        }
    }

    public void delete(int val) {
        Node node = head;

        if (node == null) {
            throw new NoSuchElementException("List is empty.");
        }

        if (node.data == val) {
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            Node n = node.next;
            if (n.data == val) {
                node.next = n.next;
                break;
            }
            node = node.next;
        } while (node != head);
    }


}
