package interviews;


import java.util.Arrays;

//        I came across a coding question in my recent interview which is mentioned below :
//
//        Given an array of non-negative integers, the goal is to travel from the first index to the last index with maximum possible score with as many jumps allowed. Score of a jump is defined as the number of index jumped multiplied by the value on the jumped index.
//        e.g. [3,7,9,10]
//
//        if the jump is from index0 to index2, the score is (2-0)*9 = 18
//
//        Sample input: [3,12,9,10]
//        Sample output: 32
//        Explanation: jump from index0 to index1 and then to index3 = (1-0) * 12 + (3-1) * 10 = 12 + 20 = 32
//
//        What are the possible ways to approach this problem? Can it be done in better than O(n^2) ?
public class MaxPossibleScore {
    public int maxScore(int[] nums) {
//        int dp[] = new int[nums.length];
//        Arrays.fill(dp, Integer.MIN_VALUE);
//        return dfs(nums, 0, dp);

        return solve(nums);
    }

    public int dfs(int[] nums, int index, int[] dp) {
        if(index == nums.length -1) {
            return 0;
        }

        if(dp[index] != Integer.MIN_VALUE) {
            return dp[index];
        }

        int result = 0;

        for (int i = index +1; i < nums.length; i++) {
            result = Math.max(result, (i - index) * nums[i] + dfs(nums, i, dp));
        }

        dp[index] = result;

        return result;
    }

//    I think it can be solved by calculating the value from the end to the beginning. In every loop, we keep the maximum value: maxi=max(maxi, current_number), and update result: res+=maxi till the start point(index 0).
//
//    take [3, 5, 2, 8, 1] for example:
//    index=4, maxi=1, res=1------loop 1
//    index=3, maxi=8, res=9------loop 2
//    index=2, maxi=8, res=17------loop 3
//    index=1, maxi=8, res=25------loop 4
//            -------stop at index 0---------------
//
//    take [1, 2, 3, 4, 5] for example:
//    index=4, maxi=5, res=5------loop 1
//    index=3, maxi=5, res=10------loop 2
//    index=2, maxi=5, res=15------loop 3
//    index=1, maxi=5, res=20------loop 4
//            -------stop at index 0---------------

//     from last to first check the maximum (T.C -> O(N))
    public int solve(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;

        int result = 0;

        for(int i = nums.length -1; i>0; i--) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            result = result + maxSoFar;      // adding is like nums[i] * (i - index)
        }

        return result;
    }
}
