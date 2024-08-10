package stack;

import java.util.Stack;
import java.util.stream.Collectors;

public class MakeGoodString {
    public String makeGood(String s) {

        if(s.isEmpty() || s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);
        int index = 1;
        //"abBAcC"
        while (index < s.length()) {
            if(stack.isEmpty()) {
                stack.push(chars[index]);
            } else {
                Character in = stack.peek();
                if(Character.toLowerCase(in) == Character.toLowerCase(chars[index]) && in != chars[index]) {
                    stack.pop();
                } else  {
                    stack.push(chars[index]);
                }
            }
            index++;
        }

        return stack.stream().map(Object::toString).collect(Collectors.joining());
    }
}
