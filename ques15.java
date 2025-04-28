// Algorithm (Using Min-Heap):
// We can solve this problem using a Min-Heap (priority queue) to efficiently find the k-th smallest element:

// Min-Heap Approach:

// A min-heap will help efficiently get the smallest element at any given point.

// The idea is to start by pushing the first element from each row into the min-heap.

// After that, repeatedly pop the smallest element from the heap, and if there are more elements in the same row, push the next element from that row into the heap.

// This way, the heap always holds the smallest unprocessed element from each row.

// After k pops, the k-th smallest element will be the last element popped from the heap.

// Steps:

// Create a min-heap and insert the first element from each row along with the row and column index.

// Pop the smallest element from the heap (it will always be the smallest among the remaining elements).

// Push the next element in the same row (if it exists) into the heap.

// Repeat steps 2 and 3 until the k-th element is popped.

import java.util.*;

public class KthSmallestInMatrix {
    
    // Define a structure to represent each element in the heap
    static class Element {
        int value, row, col;
        
        Element(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }
    
    // Function to find the k-th smallest element in the matrix
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        // Min-heap to store the elements, starting with the first element of each row
        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));

        // Initialize the heap with the first element of each row
        for (int i = 0; i < n; i++) {
            minHeap.offer(new Element(matrix[i][0], i, 0));
        }

        // Extract the minimum element from the heap k times
        Element current = null;
        for (int i = 0; i < k; i++) {
            current = minHeap.poll();
            
            // If there is another element in the same row, add it to the heap
            if (current.col + 1 < n) {
                minHeap.offer(new Element(matrix[current.row][current.col + 1], current.row, current.col + 1));
            }
        }
        
        return current.value; // The k-th smallest element
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        
        int k = 8;
        int result = kthSmallest(matrix, k);
        
        System.out.println("The " + k + "-th smallest element is: " + result);
    }
}
// Time Complexity: O(k log n)

// Space Complexity: O(n)
