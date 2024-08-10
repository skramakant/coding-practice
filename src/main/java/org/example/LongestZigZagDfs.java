package org.example;


public class LongestZigZagDfs {
    public int longestZigZag(TreeNode root) {


        return 1 + Math.max(dfs(root, false), dfs(root, true));
    }

    public int dfs(TreeNode root, boolean flag) {
        if(root == null) {
            return 0;
        }

        int x = 0;

        if(flag) {
            x = 1+ dfs(root.right, false);
        } else {
            x = 1+ dfs(root.left, true);
        }

        return x;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
