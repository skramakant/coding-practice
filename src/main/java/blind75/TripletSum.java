package blind75;

import java.util.*;

// awsome question
public class TripletSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        int size = nums.length;
        for(int i =0; i<nums.length-1; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i+1, r = size-1;
            while (l<r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if(sum < 0) {
                    l++;
                } else {
                    result.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    while (nums[l] == nums[l-1] && l<r) {
                        l++;
                    }
                }
            }
        }

        return result;
    }
}
