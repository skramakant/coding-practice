package tree;

public class IsBinaryTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        return isBST(root, null, null);
    }

    private boolean isBST(TreeNode root, TreeNode leftRange, TreeNode rightRange) {
        if(root == null) {
            return true;
        }

        if(leftRange != null && root.val <= leftRange.val) {
            return false;
        }
        if(rightRange != null && root.val >= rightRange.val) {
            return false;
        }
        // current node value should in range of left <= root && root <= right
        return isBST(root.left, leftRange, root) && isBST(root.right, root, rightRange);
    }
}
