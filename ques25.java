import java.util.Stack;

public class ques25 {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack that are smaller or equal to current element
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            // If stack is not empty, the top element is the next greater element
            if (!stack.isEmpty()) {
                nge[i] = nums[stack.peek()];
            } else {
                nge[i] = -1;
            }

            // Push the current element index to the stack
            stack.push(i);
        }

        return nge;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        int[] result = nextGreaterElements(nums);

        System.out.print("Next Greater Element for each element: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

// Time Complexity: O(n)
// We only iterate through the array once.

// Each element is pushed and popped from the stack at most once.

// 🔹 Space Complexity: O(n)