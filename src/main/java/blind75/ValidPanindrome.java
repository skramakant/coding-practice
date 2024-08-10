package blind75;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ValidPanindrome {

    // without extra space
    public boolean isPalindrome(String s) {
        if(s.trim().length() <= 1) {
            return  true;
        }

        String s1 = s.toLowerCase();

        int i =0;
        int j = s1.length() -1;

        while (i<=j) {
            if(!isValidChar(s1.charAt(i))) {
                i++;
            } else if (!isValidChar(s1.charAt(j))) {
                j--;
            }else if(s1.charAt(i) == s1.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return  true;
    }

    public boolean isValidChar(char c) {
        return ('0' <= c && c <= '9') || ('a' <= c && c <= 'z');
    }

    // space O(n)
    public boolean isPalindromeSpaceOn(String s) {
        if(s.trim().length() <= 1) {
            return  true;
        }

        String s1 = s.toLowerCase();
        ArrayList<Character> chars =  new ArrayList<>();
        for(int i=0; i<s1.length(); i++) {
            if(('0' <= s1.charAt(i) && s1.charAt(i) <= '9') || ('a' <= s1.charAt(i) && s1.charAt(i) <= 'z')){
                chars.add( s1.charAt(i));
            }
        }

        String str = chars.stream().map(String::valueOf).collect(Collectors.joining());

        System.out.println(str);

        int size = chars.size();

        int i = size/2;
        int j;
        if(size%2 == 0) {
            i = i-1;
            j = i+1;
        }else {
            j = i;
        }

        while (i>=0 && j<chars.size()) {
            if(chars.get(i) != chars.get(j)) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }
}
