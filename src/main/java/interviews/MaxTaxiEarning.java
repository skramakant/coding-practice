package interviews;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxTaxiEarning {

    // using dp
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a, b) -> Integer.compare(a[0], b[0]));
        Long[] mem = new Long[rides.length];
        return dp(rides, 0, mem);
    }

    private long dp(int[][] rides, int index, Long[] mem) {
        // reached at last
        if(index == rides.length) {
            return 0;
        }

        if(mem[index] != null) {
            return mem[index];
        }

        // do not pick the passanger
        long ans = dp(rides, index +1, mem);

        int start = rides[index][0];
        int end = rides[index][1];
        int tip = rides[index][2];

        // next trip will start where this current trip ends
        int nextTripIndex = binarySearchStart(rides, end);

        // pick it
        ans = Math.max(ans, end - start + tip + dp(rides, nextTripIndex, mem));

        mem[index] = ans;
        return ans;
    }

    public static int binarySearchStart(int[][] arr, int key) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid][0] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
//    public static int bisectLeft(double[] a, double key) {
//        int idx = Math.min(a.length, Math.abs(Arrays.binarySearch(a, key)));
//        while (idx > 0 && a[idx - 1] >= key) idx--;
//        return idx;
//    }

    // nlogn
    public long maxTaxiEarningsheap(int n, int[][] rides) {
        // sort the rides by start time
        Arrays.sort(rides, (a, b) -> a[0]-b[0]);
        long maxProfit = 0;
        // priority queue with ride ending
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        for(int i=0; i<rides.length; i++) {
            int start = rides[i][0];
            int end = rides[i][1];
            int profit = end - start + rides[i][2];

            // get the max profit till this point by iterating the heap
            while(!pq.isEmpty() && start >= pq.peek()[0]) {
                maxProfit = Math.max(maxProfit, pq.peek()[1]);
                pq.poll();
            }

            pq.offer(new long[]{end, maxProfit + profit});
        }


        while(!pq.isEmpty()) {
            maxProfit = Math.max(maxProfit, pq.peek()[1]);
            pq.poll();
        }

        return maxProfit;
    }
}
