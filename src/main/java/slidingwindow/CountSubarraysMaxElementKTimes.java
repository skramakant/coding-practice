package slidingwindow;

public class CountSubarraysMaxElementKTimes {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;

        for(int num : nums) {
            if (max < num) {
                max = num;
            }
        }

        int left = 0, right = 0;

        int maxElementCount = 0;

        long ans = 0;

        int n = nums.length;

        while (right < nums.length) {
            if(nums[right] == max) {
                maxElementCount++;
            }
            // 1,2 2,3   122 and 1223
            if(maxElementCount == k) {
                ans = ans + n-right;
            }

            while (maxElementCount >= k && left <= right) {
                if (nums[left] == max) {
                    maxElementCount--;
                }

                if(maxElementCount >= k) {
                    ans = ans + n - right;
                }

                left++;
            }

            right++;
        }

        return ans;
    }
}
