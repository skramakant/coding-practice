package blind75;

import java.util.LinkedList;

public class WordDictionary {
    CharNode root;

    public WordDictionary() {
        root = new CharNode();
    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        CharNode x = root;
        for (char c : chars) {
            if (x.nextNode[c - 'a'] == null) {
                x.nextNode[c - 'a'] = new CharNode();
            }
            x = x.nextNode[c - 'a'];
        }

        x.end = true;
    }

    public boolean search(String word) {
        return searchWord(word, 0, root);
    }

    public boolean searchWord(String word, int index, CharNode root) {
        if (index == word.length()) {
            return root.end;
        }

        if (word.charAt(index) != '.') {

            if (root.nextNode[word.charAt(index) - 'a'] == null) {
                return false;
            }

            return searchWord(word, index + 1, root.nextNode[word.charAt(index) - 'a']);

        } else {
            for (CharNode node : root.nextNode) {
                if (node != null) {
                    if (searchWord(word, index + 1, node)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

class CharNode {
    CharNode[] nextNode;
    boolean end;

    public CharNode() {
        this.nextNode = new CharNode[26];
    }
}
