// Algorithm:
// Steps:
// Identify the pivot: Find the largest index i such that arr[i] < arr[i + 1]. If no such i exists, the array is sorted in descending order, and we simply return the smallest permutation (reverse the array).

// Find the largest index j such that arr[j] > arr[i].

// Swap arr[i] and arr[j].

// Reverse the sequence from i + 1 to the end of the array.

import java.util.Arrays;

public class NextGreaterPermutation {

    // Function to find the next lexicographically greater permutation
    public static boolean nextPermutation(int[] arr) {
        int n = arr.length;
        
        // Step 1: Find the pivot
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i == -1) {
            // No such permutation exists, return the smallest permutation
            Arrays.sort(arr);
            return false;
        }

        // Step 2: Find the element to swap with
        int j = n - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }

        // Step 3: Swap elements
        swap(arr, i, j);

        // Step 4: Reverse the suffix
        reverse(arr, i + 1, n - 1);

        return true;
    }

    // Function to swap two elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to reverse the array from index 'start' to 'end'
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        if (nextPermutation(arr)) {
            System.out.println("Next permutation: " + Arrays.toString(arr));
        } else {
            System.out.println("No next permutation exists. Reversed array: " + Arrays.toString(arr));
        }
    }
}

// Time and Space Complexities:
// Time Complexity: O(n)

// Finding the pivot: O(n) time.

// Finding the element to swap: O(n) time.

// Reversing the suffix: O(n) time.

// Since all these operations are linear, the total time complexity is O(n).

// Space Complexity: O(1)

