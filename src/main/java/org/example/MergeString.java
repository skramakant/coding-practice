package org.example;

public class MergeString {
    public String mergeAlternately(String word1, String word2) {
        int i =0;
        int j =0 ;

        int l1 = word1.length();
        int l2 = word2.length();

        StringBuilder sb = new StringBuilder();

        for(;i<l1 && j < l2;) {
            sb.append(word1.charAt(i++)).append(word2.charAt(j++));
        }

        for(;i<l1;) {
            sb.append(word1.charAt(i++));
        }

        for(;j<l2;) {
            sb.append(word2.charAt(j++));
        }

        return sb.toString();
    }
}
