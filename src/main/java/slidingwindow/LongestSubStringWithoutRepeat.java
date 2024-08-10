package slidingwindow;

public class LongestSubStringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        int[] charCount = new int[228];
        int j=0;
        int ans = 0;
        for(int i=0; i<s.length(); i++) {
            // integer array can hold char
            charCount[s.charAt(i)]++;

            while(charCount[s.charAt(i)] > 1) {
                charCount[s.charAt(j)]--;
                j++;
            }

            ans = Math.max(ans, i-j+1);
        }

        return ans;
    }
}
