package liked100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombination {
    public List<String> letterCombinations(String digits) {

        if(digits.isEmpty()) {
            return List.of();
        }
        String[] keyPad = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> result = new ArrayList<>();

        //backTrack(keyPad, result, "", digits.toCharArray());
        viaQueue(keyPad, result, digits.toCharArray());

        return result;
    }

    private void backTrack(String[] keyPad, List<String> result, String temp, char[] input)
    {
        if(temp.length() == input.length) {
            result.add(temp);
            return;
        }
        int indexChar = temp.length(); // initially s  length is zero so starting from first char
        char[] indexCharArray = keyPad[input[indexChar] - '0'].toCharArray();
        for(char x : indexCharArray) {
            backTrack(keyPad, result, temp + x, input);
        }
    }

    private void viaQueue(String[] keyPad, List<String> result, char[] input) {
        LinkedList<QNode> queue = new LinkedList<>();
        queue.addLast(new QNode("", 0));

        while (!queue.isEmpty()) {
            QNode node = queue.removeFirst();

            if(node.temp.length() == input.length) {
                result.add(node.temp);
                continue;
            }
            char[] charOnIndex = keyPad[input[node.index] - '0'].toCharArray();

            for (char x : charOnIndex) {
                String t = node.temp + x;
                queue.addLast(new QNode(t, node.index + 1));
            }
        }
    }

    static class QNode {
        public String temp;
        public int index;

        public QNode(String temp, int index) {
            this.temp = temp;
            this.index = index;
        }
    }
}
