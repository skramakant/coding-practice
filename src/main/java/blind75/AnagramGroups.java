package blind75;

import java.util.*;

public class AnagramGroups {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> res = new HashMap<>();

        for(String s : strs) {
            String key = getKey(s);
            ArrayList<String> as = res.getOrDefault(getKey(s), new ArrayList<String>());
            as.add(s);
            res.put(key, as);
        }

        List<List<String>> output = new ArrayList<>();

        for (Map.Entry<String, ArrayList<String>> entry: res.entrySet()) {
            output.add(entry.getValue());
        }

        return output;
    }

    public String getKey(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

//    public String getKey(String s) {
//        char[] arr = s.toCharArray();
//        Map<Character, Integer> m = new HashMap<>();
//        for(char c : arr) {
//            m.put(c, m.getOrDefault(c, 0) + 1);
//        }
//        ArrayList<String> chars = new ArrayList<String>();
//        for(Map.Entry<Character, Integer> entry : m.entrySet()) {
//            chars.add(entry.getValue().toString());
//            chars.add(entry.getKey().toString());
//        }
//        return chars.toString();
//    }
}

