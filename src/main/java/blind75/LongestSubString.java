package blind75;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    // abcabcbb
    public int lengthOfLongestSubstring(String s) {
       Map<Character, Integer> characterIntegerMap = new HashMap<>();
       int size = s.length();
       int left = 0, right = 0;
       int maxWidth = 0;

       //abcabcbb
        // abba
       while (right < size) {

           if (characterIntegerMap.containsKey(s.charAt(right))) {
               int pos = characterIntegerMap.get(s.charAt(right)) + 1;
               // left pointer will move only forward
               if(pos > left) {
                   left = pos;
               }
           }

           characterIntegerMap.put(s.charAt(right), right);

           int width = right - left + 1;
           if(width > maxWidth) {
               maxWidth = width;
           }

           right++;
       }

       return  maxWidth;
    }
}
