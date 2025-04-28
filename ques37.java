import java.util.*;

public class ques37{

    // Function to find all unique combinations that sum up to the target
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);  // Sort the candidates to handle duplicates and pruning

        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    // Helper function to perform backtracking
    private static void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));  // If we hit the target, add the current path to the result
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Pruning: If the current number exceeds the target, no need to continue further
            if (candidates[i] > target) {
                break;
            }
            // To avoid duplicate combinations, skip the same elements
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // Add the current number and explore further with a reduced target
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, path, result);  // Not i+1 because we can reuse the same number
            path.remove(path.size() - 1);  // Backtrack by removing the last number
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = combinationSum(candidates, target);

        // Print the result
        System.out.println("Combinations that sum to " + target + ":");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
