// Sliding Window Technique
// The sliding window technique is a useful approach for solving problems involving contiguous subarrays or substrings. The technique involves using two pointers (or indices) to represent a window that "slides" over the data. It is especially efficient for problems that involve finding subarrays or substrings of a specific length or with certain properties (such as no repeating characters or meeting a sum condition).

// 🧠 How Sliding Window Works:
// Two pointers (start and end):
// You maintain two pointers:

// start (or left pointer) marks the beginning of the window.

// end (or right pointer) marks the end of the window.

// Window Expansion:
// Initially, both pointers point to the beginning of the array or string. You expand the window by moving the end pointer to the right, adding elements into the window.

// Window Contraction:
// If the window violates the condition (e.g., a duplicate character is found or the sum exceeds a target), you move the start pointer to the right, shrinking the window until the condition is satisfied again.

// Window Adjustment:
// You adjust the window size dynamically by moving the pointers. The goal is to find an optimal solution within a specific window size or with specific properties, without checking every possible subarray or substring exhaustively.

