import java.util.*;

public class ques36 {

    public static List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int index, List<Integer> currentSubset, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(currentSubset));
        
        // Explore further elements to generate all subsets
        for (int i = index; i < nums.length; i++) {
            currentSubset.add(nums[i]); // Include current element
            backtrack(nums, i + 1, currentSubset, result); // Move to the next index
            currentSubset.remove(currentSubset.size() - 1); // Backtrack (remove last element)
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = generateSubsets(nums);
        
        System.out.println("All subsets:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
