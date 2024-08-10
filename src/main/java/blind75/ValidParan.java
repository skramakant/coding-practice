package blind75;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParan {
    public boolean isValid(String s) {
        Map<Character, Character> maps = new HashMap<>(){};
        maps.put(')', '(');
        maps.put('}', '{');
        maps.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()){
            if(maps.containsKey(c)) {
                if(stack.isEmpty()) {
                    return false;
                }
                if(stack.pop() != maps.get(c)) {
                    return  false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
