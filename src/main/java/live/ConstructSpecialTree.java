package live;


//Q2. Given Inorder Traversal of a Special Binary Tree in which the key of every node is greater than keys in left and right children, construct the Binary Tree and return root.
//
//        Input: inorder[] = {5, 10, 40, 30, 28}
//        Output: root of following tree
//        40
//        /   \
//        10     30
//        /         \
//        5          28
//
//
//        Left = 2n+1
//        Right = 2n + 2
//
//
//        Input: inorder[] = {1, 5, 10, 40, 30, 15, 28, 20}
//        Output: root of following tree
//        40
//        /   \
//        10     30
//        /         \
//        5          28
//        /          /  \
//        1         15    20
//        Code:
//
//        {1, 5, 10, 40, 30, 15, 28, 20}  mid = 40
public class ConstructSpecialTree {

    SpecialTreeNode root;

    public SpecialTreeNode construct(int[] arr, int start, int end, SpecialTreeNode node) {

        if(start > end) {
            return null;
        }

        int maxElementIndex = maxElementIndex(arr, start, end);

        node = new SpecialTreeNode(arr[maxElementIndex], null, null);

        if(start == end) {
            return node;
        }
        node.left = construct(arr, start, maxElementIndex-1, node.left);
        node.right = construct(arr, maxElementIndex+1, end, node.right);
        return node;
    }


    private int maxElementIndex(int[] arr, int start, int end) {
        int max = arr[start];
        int index = start;
        for(int i = start; i<=end; i++) {
            if(arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }

        return index;
    }


    public static class SpecialTreeNode {
        int data;
        SpecialTreeNode left;
        SpecialTreeNode right;

        public SpecialTreeNode(int data, SpecialTreeNode left, SpecialTreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }


    public int[] searchRange(int[] nums, int target) {
        int end = binarySearch(nums, target);

        if(end == nums.length || nums[end] != target) {
            return new int[]{-1, -1};
        }

        int start = binarySearch(nums, target-1) +1;

        return new int[]{start, end};
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while (left < right) {
            int mid = left + (right - left)/2;

            if(target > nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int maxSubArray(int[] nums) {
        int max_so_far = Integer.MIN_VALUE;
        int max_current = 0;

        for (int num : nums) {
            max_current = max_current + num;

//            if (max_current < 0) {
//                max_current = 0;
//            }

            if (max_so_far < max_current) {
                max_so_far = max_current;
            }
        }

        return max_so_far;
    }
}
