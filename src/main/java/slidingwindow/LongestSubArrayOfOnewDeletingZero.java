package slidingwindow;

public class LongestSubArrayOfOnewDeletingZero {
    public int longestSubarray(int[] nums) {
        int ans = 0, j=0;
        int count = 0;
        for(int i =0; i<nums.length; i++) {
            if(nums[i] == 0) {
                count++;
            }

            while(count>1) {
                if(nums[j] == 0) {
                    count--;
                }
                j++;
            }

            ans = Math.max(ans, i - j);
        }

        return ans;
    }
}
