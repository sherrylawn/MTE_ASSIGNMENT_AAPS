// Algorithm (Two-Pointer Approach):


// Steps:
// Initialize left = 0 and right = n - 1 (where n is the size of the array).

// While left < right:

// If arr[left] + arr[right] == target, return the pair.

// If the sum is less than the target, increment left to move towards a larger sum.

// If the sum exceeds the target, the right to move towards a smaller sum is decreased.

// If no pair is found, return null or an appropriate message indicating no solution.

public class TwoSumSortedArray {
    
    // Function to find two numbers that add up to the target in a sorted array
    public static int[] findTwoSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int sum = arr[left] + arr[right];
            
            if (sum == target) {
                return new int[]{arr[left], arr[right]}; // Found the pair
            } else if (sum < target) {
                left++; // Move the left pointer to the right to increase the sum
            } else {
                right--; // Move the right pointer to the left to decrease the sum
            }
        }
        
        return new int[]{}; // Return an empty array if no pair is found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 8, 10};
        int target = 10;
        int[] result = findTwoSum(arr, target);
        
        if (result.length == 0) {
            System.out.println("No such pair found.");
        } else {
            System.out.println("The two numbers that add up to " + target + " are: " + result[0] + " and " + result[1]);
        }
    }
}


// Time and Space Complexities:
// Time Complexity: O(n)

// We only traverse the array once, with each pointer moving toward each other at most once. Thus, the time complexity is linear with respect to the number of elements in the array.

// Space Complexity: O(1)

// We use only a few variables for pointers and the result, so the space complexity is constant.
