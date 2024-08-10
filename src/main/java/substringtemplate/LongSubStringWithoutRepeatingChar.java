package substringtemplate;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

// Given a string s, find the length of the longest substring without repeating characters.
public class LongSubStringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        int begin = 0, end = 0, ans = 0;

        int[] map = new int[128];

        // duplicate count
        int count = 0;

        while (end < s.length()) {

            if (map[s.charAt(end)] > 0) {
                count++;
            }

            map[s.charAt(end)]++;

            end++;

            while (count > 0) {
                if (map[s.charAt(begin)] > 1) {
                    count--;
                }

                map[s.charAt(begin)]--;

                begin++;

            }

            ans = Math.max(ans, end - begin);

        }

        return ans;
    }
}
