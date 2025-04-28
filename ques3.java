public class EquilibriumIndex {
    public static int findEquilibriumIndex(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int rightSum = totalSum - leftSum - arr[i];
            if (leftSum == rightSum) {
                return i; // Found the equilibrium index
            }
            leftSum += arr[i];
        }

        return -1; // No equilibrium index found
    }

    public static void main(String[] args) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        int index = findEquilibriumIndex(arr);
        if (index != -1)
            System.out.println("Equilibrium index is: " + index);
        else
            System.out.println("No equilibrium index found");
    }
}
// Time and Space Complexity:
// Time Complexity: O(n)
// → One pass to calculate total sum + one pass to find equilibrium index.

// Space Complexity: O(1)
// → No extra space used, just a few variables.
