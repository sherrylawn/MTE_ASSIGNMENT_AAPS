public class SplitEqualPrefixSuffix {
    public static boolean canBeSplit(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            leftSum += arr[i];
            int rightSum = totalSum - leftSum;
            if (leftSum == rightSum) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0, 3};
        if (canBeSplit(arr))
            System.out.println("Yes, array can be split into equal prefix and suffix sum.");
        else
            System.out.println("No, array cannot be split into equal prefix and suffix sum.");
    }
}
// Time and Space Complexities:
// Time Complexity: O(n)
// → One pass for total sum + one pass for checking.

// Space Complexity: O(1)
// → Only variables used for sums.

