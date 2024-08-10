package org.example;


import java.util.*;

public class BinaryTreeWidth {


    class TreeNode {
        TreeNode left;
        TreeNode right;
    }
    public int widthOfBinaryTree(TreeNode root) {

        LinkedList<TreeNode> q = new LinkedList();

        int w = 0;

        if(root == null) {
            return 0;
        }

        q.add(root);

        while(!q.isEmpty()) {

            int l = q.size();

            int c = 0, nu = 0;

            while(l-- > 0) {

                TreeNode temp = q.removeFirst();


                if(temp != null) {
                    c = c+ nu + 1;
                    nu = 0;
                    q.add(temp.left);
                    q.add(temp.right);
                } else {
                    nu++;
                }

            }

            if(c > w) {
                w = c;
            }

        }

        //Map<Long, Long> map = new HashMap<>();

        return w;
    }
}
