import java.util.Scanner;

public class Ques2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        // Build prefix sum array
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        // Input query range [L, R]
        System.out.print("Enter L and R (0-based indices): ");
        int L = sc.nextInt();
        int R = sc.nextInt();

        // Calculate and print range sum
        int sum = (L == 0) ? prefix[R] : prefix[R] - prefix[L - 1];
        System.out.println("Sum from index " + L + " to " + R + " = " + sum);
    }
}
// Time and Space Complexity
// Time Complexity:

// Building prefix array: O(n)

// Querying sum: O(1)

// Space Complexity:

// Extra space for prefix array: O(n)

