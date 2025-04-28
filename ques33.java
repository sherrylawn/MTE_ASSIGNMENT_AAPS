// Applications of the Sliding Window Technique in Array Problems:
// Finding Maximum/Minimum in Subarrays:

// Given an array, find the maximum or minimum element in every subarray of size K.

// Example: Find the maximum in every sliding window of size K.

// Maximum/Minimum Sum of Subarrays:

// Find the subarray with the maximum sum (or minimum sum) for a fixed window size.

// Example: Given an array of integers, find the maximum sum of a subarray of size K.

// Longest Substring or Subarray:

// Find the longest substring or subarray that satisfies a condition.

// Example: Find the length of the longest substring with at most two distinct characters.

// Subarrays with a Sum Constraint:

// Given an array and a number S, find the length of the smallest subarray whose sum is at least S.

// Example: Find the smallest subarray with a sum greater than or equal to a given value.

// String/Array Matching Problems:

// The sliding window technique can be used to find substrings or patterns in strings or arrays.

// Example: Find all anagrams of a string within another string.

public class ques33 {
    public static int maxSum(int[] arr, int K) {
        int n = arr.length;
        if (n < K) return -1;

        // Compute the sum of the first window
        int windowSum = 0;
        for (int i = 0; i < K; i++) {
            windowSum += arr[i];
        }
        
        // Initialize max_sum with the sum of the first window
        int max_sum = windowSum;
        
        // Slide the window: remove the element going out and add the element coming in
        for (int i = K; i < n; i++) {
            windowSum += arr[i] - arr[i - K];
            max_sum = Math.max(max_sum, windowSum);
        }
        
        return max_sum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int K = 3;
        System.out.println("Maximum sum of subarray of size K: " + maxSum(arr, K));
    }
}
