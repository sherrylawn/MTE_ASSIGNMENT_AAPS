class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ques27 {

    // Function to get the length of a linked list
    public static int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    // Function to find the intersection node of two linked lists
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Get the lengths of both lists
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        // Align the pointers
        ListNode currentA = headA;
        ListNode currentB = headB;

        // Move the pointer of the longer list to align both lists
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                currentA = currentA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                currentB = currentB.next;
            }
        }

        // Traverse both lists and check for the intersection node
        while (currentA != null && currentB != null) {
            if (currentA == currentB) {
                return currentA;  // Intersection node
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }

        return null;  // No intersection
    }

    // Example usage
    public static void main(String[] args) {
        // Example Linked Lists
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(6);
        headB.next = new ListNode(7);
        headB.next.next = headA.next.next.next;  // Intersection at node with value 4

        ListNode intersection = getIntersectionNode(headA, headB);
        if (intersection != null) {
            System.out.println("The intersection node is at value: " + intersection.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
