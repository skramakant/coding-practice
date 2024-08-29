package interviews;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        // sort based on start timing
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        LinkedList<int[]> q = new LinkedList<>();

        for(int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if(!q.isEmpty() && start <= q.getLast()[1]) {
                int[] removeLast = q.removeLast();
                end = Math.max(end, removeLast[1]);
                start = removeLast[0];
            }
            q.add(new int[]{start, end});

        }

        int[][] result = new int[q.size()][2];
        int i =0;
        while(!q.isEmpty()) {
            result[i++] = q.removeFirst();
        }

        return result;
    }
}
