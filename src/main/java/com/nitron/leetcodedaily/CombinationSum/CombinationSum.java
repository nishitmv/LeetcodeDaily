package com.nitron.leetcodedaily.CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        backTrackCombinations(candidates, target, result, new ArrayList<Integer>(), 0);
        return result;

    }

    private void backTrackCombinations(int[] candidates, int target, List<List<Integer>> result, List<Integer> tempRes, int startIndex) {

        if (target < 0)
            return;
        else if (target == 0) {
            result.add(new ArrayList<>(tempRes));
        }
        else {
            int length = candidates.length;
            for (int i = startIndex; i < length; i++) {
                tempRes.add(candidates[i]);
                backTrackCombinations(candidates, target - candidates[i], result, tempRes, i);
                tempRes.remove(tempRes.size() - 1);
            }
        }
    }


}
