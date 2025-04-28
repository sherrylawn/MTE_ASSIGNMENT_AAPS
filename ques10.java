// Problem: Generate All Permutations of a Given String
// The task is to generate all possible permutations of a given string. A permutation is any possible rearrangement of the characters in the string.

// 🧠 Algorithm (Backtracking Approach):
// We can use the backtracking technique to generate all permutations. Here's the idea:

// Backtrack: For each character in the string, swap it with the current position and recursively generate permutations of the remaining characters.

// Base Case: When the current position reaches the end of the string, the current permutation is complete, and we store or print it.

// Swap back: After generating permutations with the current character at the current position, swap the characters back to explore other possibilities.

// Continue this process until all characters are fixed in every possible position.

// Steps:
// Initialize a list to store permutations.

// Use recursion to generate permutations by fixing each character at the current position and generating permutations for the remaining characters.

// After generating all permutations, return the list of permutations.

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    
    // Helper function to generate permutations
    public static void permuteHelper(String str, int left, int right, List<String> result) {
        if (left == right) {
            result.add(str);
        } else {
            for (int i = left; i <= right; i++) {
                // Swap characters at indices left and i
                str = swap(str, left, i);
                // Recur for the next character
                permuteHelper(str, left + 1, right, result);
                // Swap back to restore the original string (Backtracking)
                str = swap(str, left, i);
            }
        }
    }

    // Helper function to swap characters at indices i and j
    private static String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

    // Function to generate all permutations of a given string
    public static List<String> permute(String str) {
        List<String> result = new ArrayList<>();
        permuteHelper(str, 0, str.length() - 1, result);
        return result;
    }

    public static void main(String[] args) {
        String str = "abc";
        List<String> permutations = permute(str);
        System.out.println("All permutations: " + permutations);
    }
}

// Time and Space Complexities:
// Time Complexity: O(n!)

// There are n! possible permutations for a string of length n. For each permutation, we may need to swap n characters. So, the time complexity is O(n * n!).

// Space Complexity: O(n!)

// The space complexity arises from storing all permutations, which requires O(n!) space. The recursion depth can go up to n, so the space complexity due to the recursion stack is O(n).
