package liked100;

public class FirstOccuranceStringIndex {
    public int strStr(String haystack, String needle) {
        int window = 0;

        for(; window <= haystack.length() - needle.length(); ) {

            int i = 0;

            for(; i<needle.length(); i++) {
                if(needle.charAt(i) != haystack.charAt(window + i)) {
                    break;
                }
            }

            if(i == needle.length()) {
                return window;
            }

            window++;
        }

        return -1;
    }
}
