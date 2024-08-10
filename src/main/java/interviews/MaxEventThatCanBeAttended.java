package interviews;

import java.util.Arrays;
import java.util.PriorityQueue;


// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/submissions/
public class MaxEventThatCanBeAttended {
    public int maxEvents(int[][] events) {

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        //System.out.println(events[2][0]);

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        int totalEvents = events.length;

        int ans = 0;

        int day = 1;

        int i = 0;

        while(!pq.isEmpty() || i < totalEvents) {
            // add all the events which is happening today
            while(i < totalEvents) {
                int eventStartDate = events[i][0];
                int eventEndDate = events[i][1];
                if (eventStartDate == day) {
                    i++;
                    pq.add(eventEndDate);
                } else {
                    break;
                }
            }

            //remove expire event
            while(!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            //attand the event
            if(!pq.isEmpty()) {
                pq.poll();
                ans++;
            }

            day++;
        }

        return ans;
    }
}
