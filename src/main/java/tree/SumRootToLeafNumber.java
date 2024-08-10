package tree;

import java.util.ArrayList;

public class SumRootToLeafNumber {
    public int sumNumbers(TreeNode root) {

        if(root == null) {
            return 0;
        }

        ArrayList<Integer> pathSum = new ArrayList<>();

        preorder(root, pathSum, 0);

        return pathSum.stream().mapToInt(Integer::intValue).sum();
    }

    private void preorder(TreeNode root, ArrayList<Integer> pathSum, int sum) {

        if(root == null) {
            return;
        }

        sum = sum*10 + root.val;

        if(root.left == null && root.right == null) {
            pathSum.add(sum);
            return;
        }

        preorder(root.left, pathSum, sum);
        preorder(root.right, pathSum, sum);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

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
