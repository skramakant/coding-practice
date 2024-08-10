package liked100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// pattern problem pattern
//https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        comb(result, candidates, target, new LinkedList<>(), 0);
        return result;
    }

    private void comb(List<List<Integer>> result, int[] candidates, int target, LinkedList<Integer> temp, int i) {
        if(target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int start = i; start < candidates.length; start++) {
            if(candidates[start] <= target) {
                temp.add(candidates[start]);
                comb(result, candidates, target - candidates[start], temp, start);
                temp.removeLast();
            }
        }
    }
    // its giving duplicate combination also
    private void backtrack(List<List<Integer>> result, int[] candidates, int target, LinkedList<Integer> temp) {
        int sums = sum(temp);
        if(sums == target) {
            result.add(new ArrayList<>(temp));
            return;
        } else if (sums > target) {
            return;
        }
        for (int c : candidates) {
            temp.add(c);
            backtrack(result, candidates, target, temp);
            temp.removeLast();
        }
    }

    private int sum(List<Integer> list) {
        int x = 0;
        for (int m : list) {
            x = x + m;
        }
        return x;
    }
}
