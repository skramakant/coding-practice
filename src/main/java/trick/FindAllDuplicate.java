package trick;

import java.util.LinkedList;
import java.util.List;

public class FindAllDuplicate {
    public List<Integer> findDuplicates(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();

        for (int x : nums) {
            int index = Math.abs(x) - 1;

            if(nums[index] > 0) {
                nums[index] = -nums[index];
            } else {
                res.add(index + 1);
            }
        }

        return res;
    }
}
