public class MajorityElement {
    
    // Function to find the majority element in the array
    public static int majorityElement(int[] nums) {
        int candidate = -1, count = 0;
        
        // Phase 1: Find the candidate using Boyer-Moore Voting Algorithm
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        
        // Phase 2: Verify that the candidate is actually the majority element
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        
        if (count > nums.length / 2) {
            return candidate;
        }
        return -1;  // No majority element exists
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        
        int result = majorityElement(nums);
        System.out.println("Majority Element: " + result);
    }
}
// Time Complexity: O(n)
//   Space Complexity: O(1)
