package slidingwindow;

import java.util.Arrays;

public class MostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, ans = 0;
        long sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum = sum + nums[j];
            while (((j - i + 1) * nums[j]) - sum > k ) {
                sum = sum - nums[i++];
                //i++;
            }
            ans = Math.max(ans, (j - i + 1));
        }
        return ans;
    }
}
