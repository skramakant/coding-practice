package live;

import java.util.PriorityQueue;

public class MinimumMeetingRoom {

    // seems working
    public int minimumRoom() {
        int[][] input = new int[][]{
                {0,30},
                {5,15},
                {18, 31},
                {30, 32}
        };
        // min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return a-b;
        });
        int minRoom = 0;
        for(int i =0; i<input.length; i++) {
            int start = input[i][0];
            int end = input[i][1];

            if(pq.isEmpty()) {
                minRoom++;
                pq.add(end);
            } else {
                // room vacating or not
                int top = pq.peek();
                if (top <= start) {
                    pq.poll();
                    pq.add(end);
                } else{
                    minRoom++;
                    pq.add(end);
                }
            }
        }

//        System.out.println(minRoom);

        return minRoom;
    }
}
