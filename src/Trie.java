import java.util.HashMap;

public class Trie {

    static int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;
    }


    static void insert(TrieNode root, String key)
    {
        TrieNode pCrawl = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        pCrawl.isEndOfWord = true;
    }

    static boolean search(TrieNode root, String key)
    {
        TrieNode pCrawl = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];
        }

        return (pCrawl != null && pCrawl.isEndOfWord);
    }

    static boolean isEmpty(TrieNode root)
    {
        for (int i = 0; i < ALPHABET_SIZE; i++)
            if (root.children[i] != null)
                return false;
        return true;
    }

    static TrieNode remove(TrieNode root, String key, int depth)
    {
        if (root == null)
            return null;

        if (depth == key.length()) {
            if (root.isEndOfWord)
                root.isEndOfWord = false;
            if (isEmpty(root)) {
                root = null;
            }
            return root;
        }

        int index = key.charAt(depth) - 'a';
        root.children[index] =
                remove(root.children[index], key, depth + 1);

        if (isEmpty(root) && !root.isEndOfWord){
            root = null;
        }

        return root;
    }
}
