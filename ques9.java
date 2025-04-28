// Algorithm:
// There are a few ways to approach this problem. Here’s an efficient approach using horizontal scanning:

// Start with the first string in the list as the initial prefix.

// Iterate through the remaining strings in the list:

// For each string, compare it with the current prefix.

// If the string starts with the current prefix, continue. Otherwise, reduce the length of the prefix until it matches the start of the string.

// Return the resulting prefix after checking all strings.

// Steps:
// Initialize the prefix as the first string in the list.

// For each subsequent string:

// Compare it with the current prefix and reduce the prefix until both match.

// If at any point the prefix becomes an empty string, return an empty string (no common prefix exists).

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Initialize prefix as the first string
        String prefix = strs[0];

        // Iterate through all strings
        for (int i = 1; i < strs.length; i++) {
            // Compare prefix with the current string
            while (strs[i].indexOf(prefix) != 0) {
                // Reduce the prefix by one character from the end
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String result = longestCommonPrefix(strs);
        System.out.println("Longest common prefix: " + result);
    }
}

// Time Complexity: O(n * m)

// n is the number of strings in the list.

// m is the length of the longest string.

// We compare each string with the prefix, and in the worst case, each string might need to be compared up to its full length.

// Space Complexity: O(1)

// The space complexity is constant because we are only using a few variables to track the prefix.
