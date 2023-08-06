import java.util.NoSuchElementException;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
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

    public void insert(int data, int index) {
        // takes O(N) - linear time
        if (index == 0) {
            insertFirst(data);
            return;
        } else if (index == size) {
            insertLast(data);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(data, temp.next);
        temp.next = node;

        size++;
    }

    public void insertFirst(int data) {
        // Time of inserting a new node at the beginning of the list
        // takes O(1) - constant time
        Node node = new Node(data);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size++;
    }

    public void insertLast(int data) {
        // takes O(1) - constant time
        if (tail == null) {
            insertFirst(data);
            return;
        }

        Node node = new Node(data);
        tail.next = node;
        tail = node;
        size++;
    }

    public int deleteFirst(){
        // takes O(1) - constant time
        if (head == null) {
            throw new NoSuchElementException("The list is empty. Cannot delete from an empty list.");
        }

        int val = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteLast() {
        // takes O(1) - constant time
        if (size <= 1) {
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        int val = tail.data;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int index) {
        // takes O(N) - linear time
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        Node previous = get(index - 1);
        int val = previous.next.data;

        previous.next = previous.next.next;
        size--;
        return val;
    }

    public Node find(int value) {
        // takes O(N) - linear time
        Node node = head;
        while (node != null) {
            if (node.data == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void display() {
        // takes O(N) - linear time
        Node node = head;

        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("END");
    }

    public int getSize() {
        return size;
    }
}
