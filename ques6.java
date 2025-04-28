// Example:
// Let’s take the string: "abcabcbb"

// The longest substring without repeating characters is "abc"
// ✅ Length = 3

import java.util.HashSet;

public class LongestUniqueSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int start = 0;

        HashSet<Character> set = new HashSet<>();

        for (int end = 0; end < n; end++) {
            while (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(end));
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        int result = lengthOfLongestSubstring(str);
        System.out.println("Length of longest substring without repeating characters: " + result);
    }
}
// Time and Space Complexities:
// Time Complexity: O(n)
// → Each character is visited at most twice (once by start, once by end)

// Space Complexity: O(k)
// → k is the character set size (at most 26 for lowercase, 128 for ASCII, 256 for extended ASCII)
