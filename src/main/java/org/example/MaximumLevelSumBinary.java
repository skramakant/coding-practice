package org.example;

import java.util.*;

public class MaximumLevelSumBinary {
    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        Map<Integer, Integer> levels = new TreeMap<>();
        
        queue.add(root);

        int lebel = 1;

        while (queue.size() > 0) {
            int size = queue.size();

            int sum = 0;

            while(size > 0) {
                TreeNode top = queue.removeFirst();
                sum = sum + top.val;

                if(top.left != null) {
                    queue.add(top.left);
                }

                if(top.right != null) {
                    queue.add(top.right);
                }

                size--;
            }

            levels.put(lebel, sum);
            lebel++;
        }

        int ans = Integer.MIN_VALUE;
        int level = 1;
        for (Map.Entry<Integer, Integer> entry:levels.entrySet()) {
            if(entry.getValue() > ans) {
                ans = entry.getValue();
                level = entry.getKey();
            }
        }

        return  level;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
