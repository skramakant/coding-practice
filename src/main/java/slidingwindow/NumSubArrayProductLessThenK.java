package slidingwindow;

// https://leetcode.com/problems/subarray-product-less-than-k/discuss/108861/JavaC%2B%2B-Clean-Code-with-Explanation
public class NumSubArrayProductLessThenK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0;

        int product = 1;

        int count = 0;

        // [10,5,2,6]
        while (right < nums.length) {
            product = product*nums[right];
            while (left <= right && product >= k) {
                product = product / nums[left];
                left++;
            }

            // each array adds up to the num of sub array
            count = count + (right - left + 1);
            right++;
        }

        return count;
    }
}
