public class ques29 {
    
    // Function to check if a number is palindrome
    public static boolean isPalindrome(int x) {
        // Step 1: Handle edge cases
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        
        // Step 2: Reverse the second half of the number
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // Step 3: Check if the first half is equal to the reversed second half
        return x == reversedHalf || x == reversedHalf / 10;
    }

    // Example usage
    public static void main(String[] args) {
        int num = 121;
        if (isPalindrome(num)) {
            System.out.println(num + " is a palindrome.");
        } else {
            System.out.println(num + " is not a palindrome.");
        }
        
        int num2 = -121;
        if (isPalindrome(num2)) {
            System.out.println(num2 + " is a palindrome.");
        } else {
            System.out.println(num2 + " is not a palindrome.");
        }
    }
}
