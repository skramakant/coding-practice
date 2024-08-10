package liked100;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {
    public int removeDuplicates(int[] nums) {
        for (int i=0; i< nums.length; i++) {
            if(i+1 < nums.length && nums[i] == nums[i+1]) {
                nums[i]=Integer.MIN_VALUE;
            }
        }

        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if(nums[fast] == Integer.MIN_VALUE) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }

        System.out
                .println(Arrays.toString(nums));
        return slow;
    }

    public int removeDuplicatesMethod2(int[] nums) {

        int j = 1;
        for (int i=0; i< nums.length; i++) {
            if(i+1 < nums.length && nums[i] != nums[i+1]) {
                nums[j] = nums[i+1];
                j++;
            }
        }

        return j;
    }

}
