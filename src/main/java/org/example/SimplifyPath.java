package org.example;

import java.util.Arrays;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        var words = path.split("/");
        System.out.println(Arrays.toString(words));

        Stack<String> stack = new Stack<>();

        StringBuilder stringBuffer = new StringBuilder();

        for (String word : words) {
            if (word.length() == 0 || word.equals(".")) {
                //do nothing
            } else if (word.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(word);
            }
        }

        for (String s : stack) {
            stringBuffer.append("/").append(s);
        }

        var r = stringBuffer.toString();

        return r.isEmpty() ? "/" : r;
    }
}
