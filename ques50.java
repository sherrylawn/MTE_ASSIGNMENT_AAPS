// The Equilibrium Index of an array is an index such that the sum of the elements to the left of it is equal to the sum of the elements to the right of it.

public class ques50 {

    public static int equilibriumIndex(int[] arr) {
        int totalSum = 0;
        int leftSum = 0;

        // Calculate total sum of the array
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }

        // Traverse the array and find the equilibrium index
        for (int i = 0; i < arr.length; i++) {
            totalSum -= arr[i];  // Subtract current element from total sum

            if (leftSum == totalSum) {
                return i;  // Equilibrium index found
            }

            leftSum += arr[i];  // Update left sum for next iteration
        }

        return -1;  // No equilibrium index found
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 2};
        int index = equilibriumIndex(arr);
        System.out.println("Equilibrium Index: " + index); // Output: 2
    }
}
