package interviews;

public class LongestSubSequenceInTree {

    int longestLength = Integer.MIN_VALUE;

    public int longest(TreeNode root) {
        dfs(root);
        return longestLength;
    }

    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = dfs(root.left) +1;
        int right = dfs(root.right) + 1;

        if(root.left != null && root.left.val - root.val != 1) {
            left = 1;
        }

        if(root.right != null && root.right.val - root.val != 1) {
            right = 1;
        }

        int currentMax = Math.max(left, right);

        longestLength = Math.max(currentMax, longestLength);

        return currentMax;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
