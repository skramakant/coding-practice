package org.example;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SmallestInfiniteSet {

    PriorityQueue<Integer> pq;
    int currentIndex;
    Set<Integer> ispresent;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<Integer>((o1, o2) -> o1-o2);
        currentIndex = 1;
        ispresent = new HashSet<>();
    }

    public int popSmallest() {
        if(pq.size() > 0) {
            Integer x = pq.poll();
            if(x != null) {
                ispresent.remove(x);
                return  x;
            }
        }
        int y = currentIndex;
        currentIndex++;
        return y;
    }

    public void addBack(int num) {
        if(num < currentIndex && !ispresent.contains(num)) {
            ispresent.add(num);
            pq.add(num);
        }
    }
}
