package blind75;

import java.util.*;

public class LongestConsecutive {

    // trick
    // using set it can be done in O(n) time
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        int maxCount = 0;

        // 1, 2, 3 , 11, 12, 13, 14
        for(int i : nums) {
            if(!set.contains(i-1)) {
                // this can be start of sequence as previous num not exists in set
                int count = 1;

                int j = 1;
                while(set.contains(i+j)) {
                    count++;
                    j++;
                }

                if(count > maxCount) {
                    maxCount = count;
                }
            }
        }

        return  maxCount;
    }


    // nlogn
    public int longestConsecutiveNlogN(int[] nums) {
        TreeMap<Integer, Boolean> treeMap = new TreeMap<>();
        for(int i : nums) {
            treeMap.put(i, true);
        }

        int count = 0;

        int pre = 0;

        int maxCount = 0;

        // 1, 2, 3 , 7,8,9 10
        for (Map.Entry<Integer, Boolean> entry : treeMap.entrySet()) {
            if(count == 0) {
                count = 1;
                pre = entry.getKey();
                continue;
            }

            if( pre + 1 == entry.getKey()) {
                pre = entry.getKey();
                count++;
            } else {
                if(count > maxCount) {
                    maxCount = count;
                }
                count = 1;
                pre = entry.getKey();
            }
        }

        if (count > maxCount) {
            return  count;
        }

        return  maxCount;
    }
}
