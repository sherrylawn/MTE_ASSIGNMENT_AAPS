// Algorithm (Optimized Using Trie):
// Insert all numbers in a binary Trie.

// For each number, try to find the best match in the Trie that gives the maximum XOR.

// Keep track of the global maximum while checking.


class MaxXOR {
    static class TrieNode {
        TrieNode[] children = new TrieNode[2]; // 0 and 1
    }

    static class Trie {
        TrieNode root = new TrieNode();

        public void insert(int num) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }

        public int getMaxXOR(int num) {
            TrieNode node = root;
            int maxXOR = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int oppBit = bit ^ 1; // Try opposite bit for maximum XOR
                if (node.children[oppBit] != null) {
                    maxXOR |= (1 << i);
                    node = node.children[oppBit];
                } else {
                    node = node.children[bit];
                }
            }
            return maxXOR;
        }
    }

    public static int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        int max = 0;
        for (int num : nums) {
            trie.insert(num);
        }

        for (int num : nums) {
            max = Math.max(max, trie.getMaxXOR(num));
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println("Maximum XOR is: " + findMaximumXOR(nums));
    }
}
// ⏱️ Time and Space Complexities:
// 🔹 Time Complexity:
// Insertion in Trie: O(32 * N) = O(N)

// XOR lookup for each number: O(32 * N) = O(N)

// Total: O(N) where N = number of elements (and 32 bits for int).

// 🔹 Space Complexity:
// Trie stores bits for all numbers: O(32 * N) = O(N)

