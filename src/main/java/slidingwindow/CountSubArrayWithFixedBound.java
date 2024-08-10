package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayWithFixedBound {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        boolean minFound = false, maxFound = false;
        int start = 0;
        int minFoundIndex = 0, maxFoundIndex = 0;

        int ans = 0;

        for(int i=0; i<nums.length; i++) {
            int n =nums[i];
            // element not fitting in window
            if(n < minK || n > maxK) {
                minFound = false;
                maxFound = false;
                start = i+1;
            }

            if (n == minK) {
                minFound = true;
                minFoundIndex = i;
            }

            if(n == maxK) {
                maxFound = true;
                maxFoundIndex = i;
            }

            if(minFound && maxFound) {
                ans = ans + Math.min(minFoundIndex, maxFoundIndex) - start + 1;
            }
        }

        return ans;
    }
    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> map = new HashMap();

        // geg
        // add
        // egg
        // add
        for(int i=0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
            map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}
