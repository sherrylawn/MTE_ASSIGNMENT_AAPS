import java.util.*;

public class ques40 {

    // Function to find the element with the maximum frequency
    public static int findMaxFrequencyElement(int[] arr) {
        // Create a hash map to store the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Traverse the array and fill the frequency map
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Variables to track the element with the maximum frequency
        int maxElement = arr[0];
        int maxFrequency = frequencyMap.get(maxElement);
        
        // Find the element with the maximum frequency
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                maxElement = entry.getKey();
            }
        }
        
        return maxElement;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 2, 3, 4, 1, 2, 3};
        
        int maxFreqElement = findMaxFrequencyElement(arr);
        
        // Print the element with the maximum frequency
        System.out.println("Element with maximum frequency: " + maxFreqElement);
    }
}
