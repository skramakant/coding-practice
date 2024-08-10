package liked100;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % (nums.length);
        // reverse the array
        reverse(nums, 0, nums.length -1);
        // reverse the first part
        reverse(nums, 0, k -1);
        // reverse the second part
        reverse(nums, k, nums.length -1);
    }

    private void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int t = arr[start];
            arr[start] = arr[end];
            arr[end] = t;
            start++;
            end--;
        }
    }
}
