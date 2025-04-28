public class MaxSubarraySumK {
    public static int maxSum(int[] arr, int k) {
        int n = arr.length;
        if (n < k) {
            System.out.println("Invalid: Window size K is greater than array size.");
            return -1;
        }

        // Compute initial window sum
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Slide the window
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int result = maxSum(arr, k);
        System.out.println("Maximum sum of a subarray of size " + k + " is: " + result);
    }
}
// Time and Space Complexities:
// Time Complexity: O(n)
// → One pass for the sliding window.

// Space Complexity: O(1)
// → Constant space used.
