public class UniqueDigitCounter {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        int total = 10;  // for n = 1
        int uniqueDigits = 9;
        int availableDigits = 9;

        for (int i = 2; i <= n && availableDigits > 0; i++) {
            uniqueDigits = uniqueDigits * availableDigits;
            total += uniqueDigits;
            availableDigits--;
        }

        return total;
    }

    // Driver code
    public static void main(String[] args) {
        UniqueDigitCounter solution = new UniqueDigitCounter();
        int n = 2;
        System.out.println("Unique digit count for n = " + n + " is: " + solution.countNumbersWithUniqueDigits(n));
    }
}
// Time Complexity
// O(n) → Loop runs n times

// 📦 Space Complexity
// O(1) → Only constant variables used
