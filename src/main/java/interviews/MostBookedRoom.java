package interviews;

import java.util.*;

public class MostBookedRoom {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // end, room // meeting will end
        PriorityQueue<int[]> usedRoom = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        // available room
        PriorityQueue<Integer> avaiableRoom = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            avaiableRoom.offer(i);
        }

        int[] roomUseCount = new int[n];

        for(int[] meet : meetings) {

            // try to check what all room available
            while(!usedRoom.isEmpty() && usedRoom.peek()[0] <= meet[0]) {
                avaiableRoom.offer(usedRoom.poll()[1]);
            }

            int end = meet[1];

            if(avaiableRoom.isEmpty()) {
                // pop from used room
                int[] room = usedRoom.poll();
                end = room[0] + meet[1] - meet[0];
                avaiableRoom.offer(room[1]);
            }
            // take the room
            int roomAvaiable = avaiableRoom.poll();
            usedRoom.offer(new int[]{end, roomAvaiable});
            roomUseCount[roomAvaiable]++;
        }

        int max = Integer.MIN_VALUE;
        int result = -1;
        for (int i = 0; i < n; i++) {
            if (max < roomUseCount[i]) {
                max = roomUseCount[i];
                result = i;
            }
        }
        return result;
    }
}
