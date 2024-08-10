package org.example;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveStars {
    public String removeStars(String s) {

        char[] stars = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char star : stars) {
            if (star != '*') {
                stack.push(star);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for(Character c : stack) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }
}
