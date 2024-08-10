package blind75;

import java.util.HashMap;
import java.util.Map;

public class DuplicateArray {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int x :  nums) {
            int y = map.getOrDefault(x, 0);
            if(y >=1) {
                return true;
            }
            map.put(x, y + 1);
        }

        return false;
    }
}
