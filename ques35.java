import java.util.*;

public class ques35 {

    public static List<Integer> kMostFrequent(int[] nums, int k) {
        // Step 1: Create a frequency map
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a min-heap (priority queue)
        // We use a comparator to sort by frequency in ascending order
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
                    public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                        return e1.getValue() - e2.getValue(); // Compare frequencies
                    }
                });

        // Step 3: Add all elements to the heap, maintaining the size of the heap to be at most K
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the element with the lowest frequency
            }
        }

        // Step 4: Extract the top K elements
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }

        // Reverse the result to return in descending order of frequency
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println("K most frequent elements: " + kMostFrequent(nums, k));
    }
}
