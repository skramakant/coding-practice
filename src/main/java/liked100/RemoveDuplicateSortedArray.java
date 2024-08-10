package liked100;

import java.util.Arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/submissions/
public class RemoveDuplicateSortedArray {


    // leet code solution
    //[1,1,1,2,2,2]
    // [1,1,]
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])  // hete OR operation, put first 2 element and then check when elemnt does not match put it
                // skip it if matches
                nums[i++] = n;
        return i;
    }


    public int removeDuplicatesMySolution(int[] nums) {
        if(nums.length <=1) {
            return nums.length;
        }


        // mark the possition to be deleted
        int k = 1;
        for(int i =0; i<nums.length; ) {

            int item = nums[i];

            int j = i+1;
            while(j < nums.length && nums[j] == item) {
                k++;
                if(k > 2) {
                    nums[j] = Integer.MIN_VALUE;
                }
                j++;
            }

            i = j;
            k = 1;

        }

        // System.out.println(Arrays.toString(nums));

        // get the first possition which to be deleted
        int j = Integer.MIN_VALUE;
        for(int i =0; i< nums.length; i++) {
            if(nums[i] == Integer.MIN_VALUE) {
                j = i;
                break;
            }
        }

        // no delete position then its ok array return
        if(j == Integer.MIN_VALUE) {
            return nums.length;
        }


        // shift the element
        int slow = j, fast = j+1;

        while(fast < nums.length) {
            if(nums[fast] != Integer.MIN_VALUE) {
                nums[slow++] = nums[fast++];
            } else {
                fast++;
            }
        }

        //System.out.println(Arrays.toString(nums));

        return slow;
    }
}
