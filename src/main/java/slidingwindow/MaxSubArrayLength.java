package slidingwindow;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/?envType=daily-question&envId=2024-03-28
public class MaxSubArrayLength {
    // nums = [1,2,3,1,2,3,1,2], k = 2
    // [1,4,4,3] k = 1
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> fmap = new HashMap<>();

        int left = 0, right = 0;

        int max = 0;

        while (right < nums.length) {

            while (fmap.getOrDefault(nums[right], 0) >= k) {
                fmap.put(nums[left], fmap.getOrDefault(nums[left], 0) - 1);
                left++;
            }

            fmap.put(nums[right], fmap.getOrDefault(nums[right], 0) + 1);
            max = Math.max(max, (right - left + 1));

            right++;
        }

        return max;
    }
}
