package org.example;

import java.util.*;

public class ValidParanThesis {
    public boolean isValid(String s) {
        char[] paran = s.toCharArray();

        if (paran.length % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        Set<Character> open = new HashSet<>();
        open.add('{');
        open.add('[');
        open.add('(');

        for (char c : paran) {
            if (open.contains(c)) {
                stack.push(c);
            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                char t = stack.pop();

                if (t == '(' && c != ')') {
                    return false;
                } else if (t == '{' && c != '}') {
                    return false;
                } else if (t == '[' && c != ']') {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }
}
