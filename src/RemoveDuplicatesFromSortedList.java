
public class RemoveDuplicatesFromSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode deleteDuplicates(ListNode node) {
        if (node == null) {
            return node;
        }

        ListNode head = node;

        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
                //size--;
            } else {
                node = node.next;
            }
        }

        //tail = node;
        //tail.next = null;
        return head;
    }

}
