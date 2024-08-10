package live;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;


// very goo problem
//https://leetcode.com/problems/valid-parenthesis-string/solution/
class Solution {

    //(*)) -> true
    public boolean checkValidString(String s) {

        int[][] dp = new int[s.length()][s.length()];

        for(int[] row : dp ) {
            Arrays.fill(row, -1);
        }

        return usingDP(s, 0, 0, dp);
//        return usingTwoStack(s);
    }

    //
    public boolean usingDP(String s, int index, int openBracket, int[][] dp) {
        if(s.length() == index) {
            return openBracket == 0;
        }

        if(dp[index][openBracket] != -1) {
            return dp[index][openBracket] == 0;
        }

        boolean isValid = false;

        // 3 posibility
        if(s.charAt(index) == '*') {
            isValid = usingDP(s, index+1, openBracket+1, dp); //  treat star a open bracket

            if(openBracket>0) {
                isValid = isValid || usingDP(s, index+1, openBracket-1, dp); // treat it as close bracket
            }

            isValid = isValid || usingDP(s, index+1, openBracket, dp); // treat it as a empty string
        } else {
            if(s.charAt(index) == '(') {
                isValid = usingDP(s, index+1, openBracket+1, dp);
            } else if(openBracket> 0) {
                isValid = usingDP(s, index+1, openBracket-1, dp);
            }
        }

        if(isValid) {
            dp[index][openBracket] = 0;
        } else {
            dp[index][openBracket] = 1;
        }

        return isValid;
    }
    public boolean usingTwoStack(String s) {
        // using 2 stack

        Stack<Integer> starStack = new Stack<>();
        Stack<Integer> stack = new Stack<>();


        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else if(s.charAt(i) == '*') {
                starStack.push(i);
            } else {
                // no matching left paranthesis
                if(stack.empty() && starStack.isEmpty()) {
                    return false;
                }

                if(!stack.isEmpty()) {
                    stack.pop();
                } else if(!starStack.isEmpty()) {
                    starStack.pop();
                }
            }
        }

        while (!stack.isEmpty() && !starStack.isEmpty()) {
            // if left bracket index greater then star
            // *( -> this will always be a invalid string
            if (stack.pop() > starStack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }


}