package blind75;

import java.util.Arrays;
import java.util.Collections;

public class AnagramArray {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] cache = new int[26];


        for(int i=0;i<s.length();i++) {
            cache[ (s.charAt(i) - 'a')] = cache[ (s.charAt(i) - 'a')] + 1;
            cache[ (t.charAt(i) - 'a')] = cache[ (t.charAt(i) - 'a')] - 1;
        }

        for(int i=0;i<26; i++) {
            if(cache[i] != 0) {
                return false;
            }
        }
        int[] x = new int[]{1, 2};
        return true;
    }
}
