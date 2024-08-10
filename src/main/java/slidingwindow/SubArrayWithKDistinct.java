package slidingwindow;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarrays-with-k-different-integers/solution/
public class SubArrayWithKDistinct {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k-1); // for getting exactly k distinct
    }

    public int atMostK(int[] nums, int k) {
        int ans = 0;

        Map<Integer, Integer> exits = new HashMap<>();

        int left = 0, right = 0;

        while(right < nums.length) {
            if(exits.getOrDefault(nums[right], 0) == 0) {
                k--;
            }

            exits.put(nums[right], exits.getOrDefault(nums[right], 0) + 1);

            // if window becomes valid means k becomes 0, k unique elements in this window
            while (k < 0) {
                exits.put(nums[left], exits.getOrDefault(nums[left], 0) - 1);

                if(exits.getOrDefault(nums[left], 0) == 0) {
                    k++;
                }

                left++;
            }

            ans = ans + right - left + 1;

            right++;
        }

        return ans;
    }
}
