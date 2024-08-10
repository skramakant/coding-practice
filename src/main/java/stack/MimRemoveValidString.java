package stack;

import java.util.Stack;

public class MimRemoveValidString {
    public String minRemoveToMakeValid(String s) {
        //return usingLeftRightScan(s);
        return usingStack(s);
    }

    public String usingStack(String s) {

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();


        for(int i =0; i < sb.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            if(s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    sb.setCharAt(i, '_');
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '_');
        }

        return sb.toString().replace("_", "");
    }

    public String usingLeftRightScan(String s) {
        if (s.isEmpty()) {
            return s;
        }

        String s1 = indexToRemoveLeft(s);
        String s2 = indexToRemoveRight(s1);

        return s2.replace("_", "");
    }

    public String indexToRemoveLeft(String s) {

        char[] arr = s.toCharArray();

        int left =0; int right = s.length()-1;

        int count = 0;

        while(left <= right) {

            if(arr[left] == '(') {
                count++;
            }

            if(arr[left] == ')') {
                count--;
            }

            if (count < 0) {
                //remove string at this index
                arr[left] = '_';
                count = 0;
            }

            left++;
        }

        return String.valueOf(arr);
    }

    public String indexToRemoveRight(String s) {

        char[] arr = s.toCharArray();

        int left =0; int right = s.length()-1;

        int count = 0;

        while(left <= right) {

            if(arr[right] == ')') {
                count++;
            }

            if(arr[right] == '(') {
                count--;
            }

            if (count < 0) {
                //remove string at this index
                arr[right] = '_';
                count = 0;
            }

            right--;
        }

        return String.valueOf(arr);
    }
}
