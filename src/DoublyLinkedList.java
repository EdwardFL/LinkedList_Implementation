import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private Node head;
    private int size;

    public DoublyLinkedList() {
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

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        node.previous = null;
        if (head != null) {
            head.previous = node;
        }
        head = node;

        size++;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        Node last = head;

        if (head == null) {
            node.previous = null;
            head = node;
            return;
        }
        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
        node.previous = last;
        node.next = null;

        size++;
    }

    public void insertAfter(int value, int after) {
        Node prevNode = find(after);
        if (prevNode == null) {
            throw new IllegalArgumentException("Previous node cannot be null.");
        }

        Node node = new Node(value);
        node.next = prevNode.next;
        prevNode.next = node;
        node.previous = prevNode;
        if (node.next != null) {
            node.next.previous = node;
        }

        size++;
    }

    public void insertBefore(int value, int before) {
        Node nextNode = find(before);
        if (nextNode == null) {
            throw new IllegalArgumentException("Next node cannot be null.");
        }

        Node node = new Node(value);
        node.previous = nextNode.previous;
        nextNode.previous = node;
        node.next = nextNode;

        if (node.previous != null) {
            node.previous.next = node;
        }

        size++;
    }

    public Node find(int value) {
        // takes O(N) - linear time
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public int deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty.");
        }

        int deletedValue = head.value;

        head = head.next;
        if (head != null) {
            head.previous = null;
        }

        size--;
        return deletedValue;
    }

    public int deleteLast() {
        if (head == null) {
            throw new NoSuchElementException("List is empty.");
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        int deletedValue = current.value;

        if (current.previous != null) {
            current.previous.next = null;
        } else {
            head = null;
        }

        size--;
        return deletedValue;
    }

    public int delete(int value) {
        Node node = find(value);
        if (node == null) {
            throw new NoSuchElementException("Node cannot be null.");
        }

        if (head == null) {
            throw new NoSuchElementException("List is empty.");
        }

        if (head.value == value) {
            return deleteFirst();
        }

        Node prevNode = node.previous;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        if (nextNode != null) {
            nextNode.previous = prevNode;
        }
        size--;

        return node.value;
    }

    public void display() {
        Node node = head;
        Node last = null;
        while (node != null) {
            System.out.print(node.value + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        while (last != null) {
            System.out.print(last.value + " -> ");
            last = last.previous;
        }

        System.out.println("START");
    }
    public int getSize() {
        return size;
    }
}
