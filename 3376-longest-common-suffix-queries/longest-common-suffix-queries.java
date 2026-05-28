class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int idx = -1;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode();

        // store shortest word index at root
        root.idx = getSmallestWordIndex(wordsContainer);

        for (int i = 0; i < wordsContainer.length; i++) {
            insert(root, wordsContainer[i], i, wordsContainer);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(root, wordsQuery[i]);
        }

        return ans;
    }

    private void insert(TrieNode root, String word, int index, String[] words) {
        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            int ch = word.charAt(i) - 'a';

            if (node.child[ch] == null) {
                node.child[ch] = new TrieNode();
            }

            node = node.child[ch];

            if (node.idx == -1 ||
                words[index].length() < words[node.idx].length() ||
                (words[index].length() == words[node.idx].length() && index < node.idx)) {
                node.idx = index;
            }
        }
    }

    private int search(TrieNode root, String word) {
        TrieNode node = root;
        int res = root.idx;

        for (int i = word.length() - 1; i >= 0; i--) {
            int ch = word.charAt(i) - 'a';

            if (node.child[ch] == null) {
                break;
            }

            node = node.child[ch];
            res = node.idx;
        }

        return res;
    }

    private int getSmallestWordIndex(String[] words) {
        int idx = 0;

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < words[idx].length() ||
                (words[i].length() == words[idx].length() && i < idx)) {
                idx = i;
            }
        }

        return idx;
    }
}