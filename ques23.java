import java.util.HashSet;

class TrieNode {
    TrieNode[] children = new TrieNode[2];
}

public class ques23 {
    public static int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        int maxXOR = 0;

        // Insert numbers into Trie
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }

        // Find maximum XOR
        for (int num : nums) {
            TrieNode node = root;
            int currentXOR = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int oppositeBit = 1 - bit;
                if (node.children[oppositeBit] != null) {
                    currentXOR |= (1 << i);
                    node = node.children[oppositeBit];
                } else {
                    node = node.children[bit];
                }
            }
            maxXOR = Math.max(maxXOR, currentXOR);
        }

        return maxXOR;
    }

    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println("Maximum XOR of two numbers in the array is: " + findMaximumXOR(nums));
    }
}


// Time Complexity: O(n²), where n is the number of elements in the array.

// Space Complexity: O(1), as we are only storing a few variables.