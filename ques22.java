public class ques22 {
    public static boolean isPowerOfTwo(int n) {
        // n > 0 and n & (n - 1) == 0
        return (n > 0) && ((n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        int n = 16;
        if (isPowerOfTwo(n)) {
            System.out.println(n + " is a power of two.");
        } else {
            System.out.println(n + " is NOT a power of two.");
        }
    }
}
// Time and Space Complexities:
// 🔹 Time Complexity: O(1)
// The solution only involves a couple of bitwise operations, which take constant time.

// 🔹 Space Complexity: O(1)

// Algorithm (Bit Manipulation):
// Property of powers of two:

// A power of two in binary has only one bit set to 1.

// The expression n & (n - 1) turns off the rightmost 1 bit.

// If n is a power of two, n & (n - 1) should equal 0, because only one bit is set in n.

// Condition:

// For a number n to be a power of two, it must satisfy:

// n > 0 (because 0 and negative numbers aren't powers of two)

// n & (n - 1) == 0 (only one bit is set)