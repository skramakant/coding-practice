package liked100;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame2MinimumJump {

    //Find the leftmost position that can reach the current position/last position.
    // update current postion as last position , again find left most postion
    public int jump(int[] nums) {
        int lastPosition = nums.length -1;
        int step = 0;
        while (lastPosition > 0) {
            // start from zero and check which left postion can reach last postion
            for(int i =0; i < lastPosition; i++) {
                if(i + nums[i] >= lastPosition) {
                    lastPosition = i;
                    step++;
                    break;
                }
            }
        }

        return step;
    }

    // time limit exceed
    public int jumpBfd(int[] nums) {
        if(nums.length <= 1) {
            return 0;
        }

        Queue<Integer[]> q = new LinkedList<>();

        int lastIndex = nums.length -1;
        // index , jumpCount
        q.add(new Integer[]{0, 0});

        while (!q.isEmpty()) {

            int size = q.size();

            while(size-- > 0) {

                Integer[] item = q.poll();

                int atIndex = item[0];
                int minJump = item[1];

                int maxJumpFromIndex = nums[atIndex];

                if(atIndex + maxJumpFromIndex >= lastIndex ) {
                    return minJump + 1;
                }

                for(int i =1; i<=maxJumpFromIndex; i++) {
                    q.add(new Integer[]{atIndex + i, minJump + 1});
                }
            }
        }

        return 0;
    }
}
