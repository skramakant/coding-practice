package liked100;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for (int i =1; i < nums.length; i++) {
            if(major == nums[i]) {
                count++;
            }else {
                count--;
            }

            if(count ==0) {
                major = nums[i];
            }
        }
        return major;
    }
    public int majorityElementMy(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int f = Integer.MIN_VALUE;
        int r = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(f < entry.getValue()) {
                f = entry.getValue();
                r = entry.getKey();
            }
        }

        return r;
    }
}
