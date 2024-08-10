package tree;

public class KthSmallestElementBst {
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }

        int x = kthSmallest(root.left, k);

        if(x != -1) {
            return x;
        }

        count++;

        if(count == k) {
            return root.val;
        }

        return kthSmallest(root.right, k);
    }


    // can also be done via heap
}
