public class ques21 {
    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] result = countBits(n);
        System.out.print("Number of 1s from 0 to " + n + ": ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}


// Time and Space Complexities:
// 🔹 Time Complexity: O(n)
// Each i from 1 to n is processed once.

// 🔹 Space Complexity: O(n)
// Output array of size n+1.