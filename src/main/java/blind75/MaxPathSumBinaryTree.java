package blind75;

public class MaxPathSumBinaryTree {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(MaxPathTreeNode root) {
        maxSum(root);
        return maxSum;
    }

    public int maxSum(MaxPathTreeNode root) {
        if (root == null) {
            return  0;
        }
        int left = maxSum(root.left);
        int right = maxSum(root.right);

        maxSum = Math.max(maxSum, right + root.val + left);

        int t = root.val + Math.max(right, left);

        if(t < 0) {
            t = 0;
        }

        return t;
    }
}

class MaxPathTreeNode {
      int val;
    MaxPathTreeNode left;
    MaxPathTreeNode right;
    MaxPathTreeNode() {}
    MaxPathTreeNode(int val) { this.val = val; }
    MaxPathTreeNode(int val, MaxPathTreeNode left, MaxPathTreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

