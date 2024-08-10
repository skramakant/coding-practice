package liked100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

// 5*
// https://leetcode.com/problems/insert-delete-getrandom-o1/
public class RandomizedSet {

    HashMap<Integer, Integer> mapValueLocation;
    ArrayList<Integer> values;

    Random random;
    public RandomizedSet() {
        mapValueLocation = new HashMap<>();
        values = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(mapValueLocation.containsKey(val)) {
            return false;
        }
        mapValueLocation.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(mapValueLocation.containsKey(val)) {
            int loc = mapValueLocation.get(val);
            int lastValueInArray = values.get(values.size()-1);
            values.set(loc, lastValueInArray);
            values.remove(values.size()-1);
            mapValueLocation.put(lastValueInArray, loc);
            mapValueLocation.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }
}
