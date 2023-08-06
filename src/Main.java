public class Main {
    public static void main(String[] args) {

        System.out.println("================= SinglyLinkedList =================");
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(5);
        linkedList.insertFirst(2);
        linkedList.insertLast(40);
        linkedList.insertLast(50);
        linkedList.insert(10, 2);
        linkedList.insert(20,3);
        linkedList.insert(30, 1);

        linkedList.display();
        System.out.println("LinkedList size: " + linkedList.getSize());
        System.out.println("Element " + linkedList.deleteFirst() + " was deleted");
        linkedList.display();
        System.out.println("LinkedList size: " + linkedList.getSize());
        linkedList.display();
        System.out.println("Element " + linkedList.deleteLast() + " was deleted");
        linkedList.display();
        System.out.println("LinkedList size: " + linkedList.getSize());
        System.out.println("Element " + linkedList.delete(3) + " was deleted");
        linkedList.display();
        System.out.println("LinkedList size: " + linkedList.getSize());

        System.out.println("================= DoublyLinkedList =================");
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertFirst(5);
        doublyLinkedList.insertFirst(2);
        doublyLinkedList.insertFirst(12);
        doublyLinkedList.insertFirst(19);
        doublyLinkedList.insertLast(22);
        doublyLinkedList.insertLast(73);
        doublyLinkedList.insertLast(29);
        doublyLinkedList.insertAfter(10, 2);
        doublyLinkedList.insertAfter(20,22);
        doublyLinkedList.insertAfter(30, 73);
        doublyLinkedList.display();
        System.out.println("DoublyLinkedList size: " + doublyLinkedList.getSize());
        doublyLinkedList.insertBefore(25, 20);
        doublyLinkedList.insertBefore(99, 10);
        doublyLinkedList.display();
        System.out.println("DoublyLinkedList size: " + doublyLinkedList.getSize());
        doublyLinkedList.deleteFirst();
        doublyLinkedList.display();
        System.out.println("DoublyLinkedList size: " + doublyLinkedList.getSize());
        doublyLinkedList.deleteLast();
        doublyLinkedList.display();
        System.out.println("DoublyLinkedList size: " + doublyLinkedList.getSize());
        doublyLinkedList.delete(99);
        doublyLinkedList.display();
        System.out.println("DoublyLinkedList size: " + doublyLinkedList.getSize());
        System.out.println("================= Circular SinglyLinkedList =================");
        CircularSinglyLinkedList circularSinglyLinkedList = new CircularSinglyLinkedList();
        circularSinglyLinkedList.insert(10);
        circularSinglyLinkedList.insert(22);
        circularSinglyLinkedList.insert(13);
        circularSinglyLinkedList.insert(2);
        circularSinglyLinkedList.insert(42);
        circularSinglyLinkedList.display();
        circularSinglyLinkedList.delete(2);
        circularSinglyLinkedList.display();
        System.out.println("================= Circular DoublyLinkedList =================");
        CircularDoublyLinkedList circularDoublyLinkedList = new CircularDoublyLinkedList();
        circularDoublyLinkedList.insert(10);
        circularDoublyLinkedList.insert(22);
        circularDoublyLinkedList.insert(13);
        circularDoublyLinkedList.insert(2);
        circularDoublyLinkedList.insert(42);
        circularDoublyLinkedList.display();
        System.out.println("Circular DoublyLinkedList size: " + circularDoublyLinkedList.getSize());
        System.out.println("Element " + circularDoublyLinkedList.delete(13) + " was deleted");
        circularDoublyLinkedList.display();
        System.out.println("Circular DoublyLinkedList size: " + circularDoublyLinkedList.getSize());
    }
}