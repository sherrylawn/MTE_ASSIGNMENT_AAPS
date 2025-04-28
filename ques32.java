// 1. Initialize an empty stack and a variable `maxArea` to store the maximum area.
// 2. Iterate over the histogram bars:
//    a. If the stack is empty or the current bar is higher than the bar at the top of the stack, push the current index onto the stack.
//    b. If the current bar is shorter than the bar at the top of the stack:
//       - Pop the stack and calculate the area of the rectangle with the popped bar as the height.
//       - The width of the rectangle is determined by the difference between the current index and the index of the new top of the stack.
// 3. After the iteration, there may still be bars in the stack. Repeat the above steps for these bars.
// 4. Return the `maxArea`.
import java.util.Stack;

public class ques32{

    public static int largestRectangleArea(int[] heights) {
        // Initialize an empty stack
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            // While the stack is not empty and the current height is less than the height at the top of the stack
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                // Determine the width of the rectangle
                int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                // Calculate the area and update maxArea if it's larger
                maxArea = Math.max(maxArea, height * width);
            }
            // Push the current index to the stack
            stack.push(i);
        }

        // Now process the remaining elements in the stack
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = (stack.isEmpty()) ? n : n - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights));
    }
}
