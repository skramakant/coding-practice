package interviews;

// https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/
public class MinDiffTargetChoosenElement {
    public int minimizeTheDifference(int[][] mat, int target) {
        // object array, it will get pass as reference
        Integer[][] dp = new Integer[mat.length][5001];
        return dfs(mat, target, 0, 0, dp);
    }

    public int dfs(int[][] mat, int target, int sum, int index, Integer[][] dp) {
        if(mat.length == index) {
            return Math.abs(sum- target);
        }

        if(dp[index][sum] != null) {
            return dp[index][sum];
        }

        int ans = Integer.MAX_VALUE;

        for(int i=0; i<mat[0].length; i++) {
            ans = Math.min(ans, dfs(mat, target, sum + mat[index][i], index+1, dp));
        }

        return dp[index][sum] = ans;
    }

}
