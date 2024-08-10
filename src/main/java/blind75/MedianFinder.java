package blind75;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        minHeap = new PriorityQueue<>();
    }

    //Max 3,2,1
    // Min 4,5,6


    //Max 3,2,1
    //MIn 4,5

    //Max -1
    //Min -3,-2
    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        if(maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
    }

    //Min 3,4
    //Max 2,1

    //Min -2, -1
    //Max -3, -4

    public double findMedian() {
        var minHeapSize = minHeap.size();
        var maxHeapSize = maxHeap.size();
        if (minHeapSize == maxHeapSize && maxHeapSize > 0) {
            return ((minHeap.peek() + maxHeap.peek()) * 1.0)/2;
        }
        return minHeap.peek();
    }

}
