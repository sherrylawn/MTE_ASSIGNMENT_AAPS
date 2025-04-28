// Algorithm:
// Initialize:

// maxSoFar = nums[0]

// maxProd = nums[0]

// minProd = nums[0]

// Iterate from index 1 to n-1:

// If nums[i] < 0, swap maxProd and minProd

// Update:

// maxProd = max(nums[i], nums[i] * maxProd)

// minProd = min(nums[i], nums[i] * minProd)

// Update maxSoFar = max(maxSoFar, maxProd)

// Return maxSoFar


public class MaxProductSubarray {
    public static int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            // Swap max and min if current number is negative
            if (current < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(current, current * maxProd);
            minProd = Math.min(current, current * minProd);

            result = Math.max(result, maxProd);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println("Maximum product subarray is: " + maxProduct(nums));
    }
}
// ⏱️ Time and Space Complexities:
// 🔹 Time Complexity: O(n)
// Single pass through the array.

// 🔹 Space Complexity: O(1)
// Constant extra space for variables (maxProd, minProd, etc.)
