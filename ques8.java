public class LongestPalindromicSubstring {
    
    // Helper function to expand around a center and find the longest palindrome
    private static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the longest palindrome for this center
        return s.substring(left + 1, right);
    }

    // Main function to find the longest palindromic substring
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        String longest = "";
        
        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindrome (expand around a single character)
            String palindrome1 = expandAroundCenter(s, i, i);
            // Even-length palindrome (expand around a pair of characters)
            String palindrome2 = expandAroundCenter(s, i, i + 1);
            
            // Compare and choose the longer palindrome
            if (palindrome1.length() > longest.length()) {
                longest = palindrome1;
            }
            if (palindrome2.length() > longest.length()) {
                longest = palindrome2;
            }
        }
        
        return longest;
    }

    public static void main(String[] args) {
        String str = "babad";
        String result = longestPalindrome(str);
        System.out.println("Longest palindromic substring: " + result);
    }
}
// Time and Space Complexities:
// Time Complexity: O(n^2)
// → In the worst case, for each character (which is O(n)), we may expand around it for the entire string (O(n)). Thus, the total time complexity is O(n^2).

// Space Complexity: O(1)
// → We are only using a few extra variables (not counting the space needed to store the result string). The space complexity is constant.

