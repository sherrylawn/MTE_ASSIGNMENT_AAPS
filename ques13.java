// Algorithm:
// The problem can be solved using the two-pointer approach. We traverse both linked lists simultaneously and at each step, we pick the smaller element from the two lists and add it to the result list.

// Steps:
// Initialize a dummy node to simplify the merging process. A dummy node helps to avoid edge cases (like empty lists) and makes the code cleaner.

// Use two pointers (l1 and l2), initialized at the start of the two linked lists.

// Compare the nodes pointed by l1 and l2:

// If the value at l1 is smaller, append l1 to the result list and move l1 forward.

// If the value at l2 is smaller, append l2 to the result list and move l2 forward.

// If one list is exhausted (i.e., l1 or l2 reaches null), append the remaining part of the other list to the result list (since it is already sorted).

// Return the merged list, starting from the node after the dummy node.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MergeSortedLinkedLists {

    // Function to merge two sorted linked lists
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);  // Dummy node to simplify the code
        ListNode current = dummy;  // Pointer to build the new list

        // Traverse both lists
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;  // Attach l1 to the result list
                l1 = l1.next;  // Move l1 to the next node
            } else {
                current.next = l2;  // Attach l2 to the result list
                l2 = l2.next;  // Move l2 to the next node
            }
            current = current.next;  // Move the current pointer forward
        }

        // If one list is not exhausted, attach the remaining part of the other list
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;  // Return the merged list starting from the first element
    }

    // Function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create two sorted linked lists
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        // Merge the two sorted linked lists
        ListNode mergedList = mergeTwoLists(l1, l2);

        // Print the merged list
        printList(mergedList);
    }
}
// Time and Space Complexities:
// Time Complexity: O(n + m)

// We are traversing both linked lists l1 and l2. If the length of l1 is n and the length of l2 is m, then the total time taken is proportional to the sum of both lengths (n + m).

// Space Complexity: O(1)
