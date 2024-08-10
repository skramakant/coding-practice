package substringtemplate;

//https://leetcode.com/problems/minimum-window-substring/


/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 */
public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        int[] tmap = new int[128];
        for (char x : t.toCharArray()) {
            tmap[x]++;
        }

        int tsize = t.length();

        int begin = 0, end = 0, minLength = Integer.MAX_VALUE, minStart = 0;

        while (end < s.length()) {
            if (tmap[s.charAt(end)] > 0) {
                tsize--;
            }

            tmap[s.charAt(end)]--;

            end++;

            while (tsize == 0) {

                int tempMinLength = end - begin;

                if (tempMinLength < minLength) {
                    minLength = tempMinLength;
                    minStart = begin;
                }

                tmap[s.charAt(begin)]++;

                if (tmap[s.charAt(begin)] > 0) {
                    tsize++;
                }

                begin++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minStart, minStart + minLength);
    }
}
