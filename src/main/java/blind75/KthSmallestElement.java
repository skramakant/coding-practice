package blind75;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class KthSmallestElement {

    int count = 0;
    public int kthSmallestX(KthTreeNode root, int k) {

        if(root == null) {
            return -1;
        }
        int x = kthSmallest(root.left, k);
        if(x != -1) {
            return x;
        }

        count++;
        if (count == k) {
            return root.val;
        }
        return kthSmallest(root.right, k);
    }


    PriorityQueue<KthTreeNode> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.val, o1.val));
    public int kthSmallest(KthTreeNode root, int k) {
        if(root == null) {
            return 0;
        }
        smallest(root, k);
        return Objects.requireNonNull(priorityQueue.poll()).val;
    }

    public void smallest(KthTreeNode root, int k){
        if(root == null) {
            return;
        }
        smallest(root.left, k);

        if(!priorityQueue.isEmpty() && priorityQueue.size() == k) {
            if (priorityQueue.peek().val > root.val) {
                priorityQueue.poll();
            }
        }

        if(priorityQueue.size() < k ) {
            priorityQueue.add(root);
        }

        smallest(root.right, k);
    }
}
class KthTreeNode {
    int val;
    KthTreeNode left;
    KthTreeNode right;
    KthTreeNode() {}
    KthTreeNode(int val) { this.val = val; }
    KthTreeNode(int val, KthTreeNode left, KthTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
