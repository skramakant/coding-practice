package live;

// //aaabbcddbbbaaa
public class RemoveDuplicateFromString {

    public String removeDuplicateCharString(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);

        int j = 0;
        for(int i =0; i<stringBuilder.length(); i++) {
            if(j < 1) {
                j++;
            } else {
                if(stringBuilder.charAt(i) != stringBuilder.charAt(i-1)) {
                    stringBuilder.setCharAt(j, stringBuilder.charAt(i));
                    j++;
                }
            }
        }
        return stringBuilder.substring(0, j).toString();
    }
}
