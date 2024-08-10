package blind75;

public class LongestCharacterReplacement {

    //ABAB

    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;

        int[] freq = new int[26];

        int maxSubStringLength = 0;

        int mostFrequentLetter = 0;

        while(right < s.length()) {
            freq[s.charAt(right) - 'A']++;

            mostFrequentLetter = Math.max(mostFrequentLetter, freq[s.charAt(right) - 'A']);

            int letterToChange = (right - left + 1) - mostFrequentLetter;

            if(letterToChange > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }else {
                maxSubStringLength = Math.max(maxSubStringLength, right - left + 1);
            }

            right++;
        }

        return  maxSubStringLength;
    }

}
