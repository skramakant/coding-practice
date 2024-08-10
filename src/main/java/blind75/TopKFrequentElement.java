package blind75;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElement {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[k];

        int i = 0;

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(i < k) {
                pq.add(entry);
            } else {
                if(pq.size() > 0 && entry.getValue() > pq.peek().getValue()) {
                    pq.poll();
                    pq.add(entry);
                }
            }
            i++;
        }

//        List<Map.Entry<Integer, Integer>> l = map.entrySet().stream()
//                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
//                .collect(Collectors.toList());

//        for(Map.Entry<Integer, Integer> entry : l) {
//            res[i++] = entry.getKey();
//            if(i == k) {
//                break;
//            }
//        }

        return pq.stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    //O(n)
    public int[] topKFrequentBucketSort(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>(nums.length + 1);

        for (int i = 0; i<nums.length +1 ; i++) {
            bucket.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            bucket.get(entry.getValue()).add(entry.getKey());
        }

        int[] res = new int[k];

        int c = 0;

        for(int i= nums.length; i>=0;i--) {
            ArrayList<Integer> al = bucket.get(i);
            if(al.size() > 0) {
                for (Integer a : al) {
                    res[c] = a;
                    c++;
                    if(c == k) {
                        return res;
                    }
                }
            }
        }

        return res;
    }
}
