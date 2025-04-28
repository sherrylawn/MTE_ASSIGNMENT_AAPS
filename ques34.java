import java.util.HashMap;

public class ques34
 {
    public static int longestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLength = 0;

        while (right < n) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            // If there are more than 2 distinct characters, shrink the window
            while (map.size() > 2) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "eceba";
        System.out.println("Length of longest substring with at most two distinct characters: " + longestSubstring(s));
    }
}
