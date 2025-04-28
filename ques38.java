import java.util.*;

public class ques38 {

    // Function to generate all permutations of the given array
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        backtrack(nums, used, currentPermutation, result);
        return result;
    }

    // Helper function to perform backtracking
    private static void backtrack(int[] nums, boolean[] used, List<Integer> currentPermutation, List<List<Integer>> result) {
        // Base case: if the current permutation contains all numbers, add it to the result
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));  // Add a copy of the current permutation
            return;
        }

        // Try each number in nums
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;  // Skip if the number is already used
            }
            
            // Include nums[i] in the current permutation
            used[i] = true;
            currentPermutation.add(nums[i]);
            
            // Recursively generate the remaining permutations
            backtrack(nums, used, currentPermutation, result);
            
            // Backtrack: Remove the last added element and mark it as unused
            currentPermutation.remove(currentPermutation.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        
        List<List<Integer>> result = permute(nums);
        
        //
