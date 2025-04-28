class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ques26 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to simplify edge cases (like removing the head node)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialize fast and slow pointers
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n+1 steps ahead to maintain the gap
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both fast and slow pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the n-th node from the end
        slow.next = slow.next.next;

        // Return the head of the updated list
        return dummy.next;
    }

    // Helper method to print the linked list
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveNthFromEnd solution = new RemoveNthFromEnd();
        
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        solution.printList(head);

        // Remove the 2nd node from the end (i.e., the node with value 4)
        head = solution.removeNthFromEnd(head, 2);

        System.out.println("Updated List after removal:");
        solution.printList(head);
    }
}
