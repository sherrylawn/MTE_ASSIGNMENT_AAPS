class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class ques49 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }

        return pA; // could be null or intersection node
    }

    public static void main(String[] args) {
        // Example setup
        ListNode common = new ListNode(8);
        common.next = new ListNode(10);

        ListNode headA = new ListNode(3);
        headA.next = new ListNode(7);
        headA.next.next = common;

        ListNode headB = new ListNode(99);
        headB.next = new ListNode(1);
        headB.next.next = common;

        ListNode intersection = getIntersectionNode(headA, headB);
        System.out.println("Intersection at node with value: " + (intersection != null ? intersection.val : "None"));
    }
}
