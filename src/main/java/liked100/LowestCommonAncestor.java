package liked100;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) {
            return null;
        }

        if(root == p) {
            return root;
        }

        if(root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null) {
            return right;
        } else if(right == null) {
            return left;
        } else {
            return root;
        }

    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
}
