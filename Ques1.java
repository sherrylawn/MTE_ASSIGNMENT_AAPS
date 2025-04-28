// A prefix sum array stores the cumulative sums of elements up to each index, allowing for efficient range sum queries in constant time. It is widely used in problems involving subarray sums, frequency counting, and dynamic programming optimizations.

// Applications
// Range Sum Queries (most common):

// Efficient in answering multiple queries like "What is the sum from index i to j?"

// Time complexity:

// Building prefix: O(n)

// Each query: O(1)

// Checking Subarrays with Given Sum:

// Used to determine if there’s a subarray with a specific sum efficiently.

// Finding Equilibrium Index:

// An index where the sum of elements on the left is equal to the right.

// 2D Prefix Sum Arrays (also called integral images):

// For matrix-based problems where you need to query the sum of submatrices in constant time.

// Used in image processing and dynamic programming on grids.

// Prefix XOR / Product:

// The concept extends to other operations like XOR or multiplication (with appropriate care for operations that aren't invertible).

// Competitive Programming:

// Heavily used in problems involving frequent range queries or optimization of brute-force approaches.
