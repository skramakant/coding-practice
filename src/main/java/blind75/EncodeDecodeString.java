package blind75;

import java.util.ArrayList;
import java.util.List;

//https://www.lintcode.com/problem/659/
//
public class EncodeDecodeString {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */

    // words can have any chars so normal split will not work
    // so we need to store word count followed by word
    public String encode(List<String> strs) {
        // write your code here
        StringBuffer s = new StringBuffer();
        for (String str : strs) {
            s.append(str.length()).append("|").append(str);
        }
        return s.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List<String> res = new ArrayList<>();

        char[] chars = str.toCharArray();

        int num = 0;

        for(int i = 0; i<chars.length;) {
            int count = 0;
            if(chars[i] >= '1' && chars[i] <= '9') {
                num = num * 10 + (chars[i] - '0');
                i++;
            } else if(chars[i] == '|') {
                count = num;
                num = 0;

                char[] temp = new char[count];
                int t = 0;
                while (count > 0) {
                    temp[t++] = chars[++i];
                    count--;
                }

                i++;

                res.add(new String(temp));
            }
        }

        return  res;
    }
}
