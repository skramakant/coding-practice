package interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDiff {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList();

        int i =0, j = 1;

        int diff = Math.abs(arr[j] - arr[i]);

        for(int k=2; k<arr.length; k++) {
            if(Math.abs(arr[k-1] - arr[k]) < diff) {
                diff = Math.abs(arr[k-1] - arr[k]);
            }
        }

        while(i < arr.length && j < arr.length) {
            if(Math.abs(arr[j] - arr[i]) == diff) {
                result.add(List.of(arr[i], arr[j]));
            }
            i++; j++;
        }

        return result;
    }
}
