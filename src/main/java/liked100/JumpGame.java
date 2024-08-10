package liked100;

public class JumpGame {
    // backward
    // check last index reachable from befor index
    // make before index as last index
    public boolean canJump(int[] nums) {
        // can be solved by bfs also
        ///Queue<Integer> q. = new Queue()
        //return dfs(nums, 0, false);

        int last = nums.length-1;

        for(int i = last-1; i>=0; i--) {
            if(i+nums[i] >= last) {
                last = i;
            }
        }

        return last<=0;
    }


    // time limit exceed
    private boolean dfs(int[] nums, int index, boolean r) {

        if(index == nums.length-1) {
            return true;
        }

        if (index < nums.length) {
            for(int i =1; i<=nums[index]; i++) {
                r = r || dfs(nums, index + i, r);
                if (r) {
                    break;
                }
            }
        }

        return r;
    }
}
