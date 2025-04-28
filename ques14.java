public class MedianOfTwoSortedArrays {

    // Function to find the median of two sorted arrays
    public static double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length) {
            // Ensure A is the smaller array
            return findMedianSortedArrays(B, A);
        }

        int m = A.length;
        int n = B.length;

        int low = 0, high = m;

        while (low <= high) {
            int partitionA = (low + high) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;

            // Handle edge cases where partitionA or partitionB is out of bounds
            int maxA = (partitionA == 0) ? Integer.MIN_VALUE : A[partitionA - 1];
            int minA = (partitionA == m) ? Integer.MAX_VALUE : A[partitionA];

            int maxB = (partitionB == 0) ? Integer.MIN_VALUE : B[partitionB - 1];
            int minB = (partitionB == n) ? Integer.MAX_VALUE : B[partitionB];

            // Check if we have found the correct partition
            if (maxA <= minB && maxB <= minA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxA, maxB) + Math.min(minA, minB)) / 2.0;
                } else {
                    return Math.max(maxA, maxB);
                }
            } else if (maxA > minB) {
                high = partitionA - 1;
            } else {
                low = partitionA + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }

    public static void main(String[] args) {
        int[] A = {1, 3};
        int[] B = {2};

        double median = findMedianSortedArrays(A, B);
        System.out.println("Median: " + median);
    }
}
