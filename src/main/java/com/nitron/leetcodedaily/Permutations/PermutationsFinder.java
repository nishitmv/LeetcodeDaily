package com.nitron.leetcodedaily.Permutations;

import java.util.ArrayList;
import java.util.List;

public class PermutationsFinder {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> permutations = new ArrayList<>();
            backTrackPermutations(nums, permutations, new ArrayList<>(), nums.length);
            return permutations;


    }

    private void backTrackPermutations(int[] nums, List<List<Integer>> permutations, List<Integer> permutation,  int length) {

        if(nums.length == permutation.size()) {
            permutations.add(new ArrayList<>(permutation));

        }
      for(int i = 0; i< length; i++)
      {
          if(!permutation.contains(nums[i])) {
              permutation.add(nums[i]);

              backTrackPermutations(nums, permutations, permutation, length);

              permutation.remove(permutation.size() - 1);
          }

      }
    }
}

