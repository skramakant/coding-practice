package tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();

        if(root == null) {
            return result;
        }

        queue.add(root);

        boolean zigZagFlag = false;

        while (!queue.isEmpty()) {

            int size = queue.size();

            LinkedList<Integer> levelList = new LinkedList<>();

            while (size-- > 0) {
                TreeNode node = queue.removeFirst();

                levelList.add(node.val);

                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
            }

            if(zigZagFlag) {
                Collections.reverse(levelList);
            }

            zigZagFlag = !zigZagFlag;

            result.add(levelList);

        }

        return result;
    }

    private class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
