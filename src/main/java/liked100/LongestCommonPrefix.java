package liked100;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {

    // sort laxicographically
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        // compare first and last string, most unmatch string

        StringBuilder stringBuilder = new StringBuilder();

        int lastIndex = strs.length -1;
        for(int i =0; i<strs[0].length() && i<strs[lastIndex].length(); i++) {
            if(strs[0].charAt(i) == strs[lastIndex].charAt(i)) {
                stringBuilder.append(strs[0].charAt(i));
            } else {
                break;
            }
        }

        return stringBuilder.toString();
    }

    //sort based of string length
    public String longestCommonPrefix1(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        int i =0;
        while (i < strs[0].length()) {
            int j =1;
            for(; j<strs.length; j++) {
                if(strs[0].charAt(i) == strs[j].charAt(i)) {
                    //
                } else {
                    break;
                }
            }

            if(j == strs.length) {
                stringBuilder.append(strs[0].charAt(i));
            } else {
                break;
            }

            i++;
        }
        return stringBuilder.toString();
    }
}
