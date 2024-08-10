package org.example;

public class LongestPalindromSubsequenceDP {
    public int longestPalindromeSubseq(String s) {
        String s1 = s;
        String s2 = reverse(s);
        int l = s.length();

        int[][] cache = new int[l+1][l+1];

        for(int i=1;i<=l;i++) {
            for(int j=1;j<=l;j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    cache[i][j] = 1 + cache[i-1][j-1];
                } else {
                    cache[i][j] = Math.max(cache[i][j-1], cache[i-1][j]);
                }
            }
        }

        return cache[l][l];
    }

    public String reverse(String s) {
        int i=0;
        int j = s.length()-1;

        char[] arr = s.toCharArray();

        while(i<=j) {
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }

        return new String(arr);
    }
}
