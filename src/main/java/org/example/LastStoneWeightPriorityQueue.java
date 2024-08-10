package org.example;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeightPriorityQueue {
    //[2,7,4,1,8,1]
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });


        for (int i : stones) {
            pq.add(i);
        }

        while (!pq.isEmpty()) {
            Integer x = pq.poll();
            Integer y = pq.poll();

            if (x != null && y != null) {
                if (x > y) {
                    pq.add(x - y);
                } else if (y > x) {
                    pq.add(y - x);
                }
            } else {
                if(x != null) {
                    return  x;
                }

                if(y != null) {
                    return  y;
                }
            }
        }

        return 0;
    }
}
