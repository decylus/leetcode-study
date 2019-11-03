package com.decylus.study.t000.k039;

import java.util.*;

/**
 * Created on 2019-11-03.
 *
 * 3ms, 36.6mb
 *
 * @author jiawei
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Deque<Integer> solution = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        backTrack(candidates, target, 0, solution, result);
        return result;
    }

    private void backTrack(int[] candidates, int target, int start, Deque<Integer> solution, List<List<Integer>> result){
        //find the solution
        if (target == 0){
            List<Integer> list = new ArrayList<>(solution);
            result.add(list);
            return;

        }
        for (int i = start; i < candidates.length; i++){
            if (target - candidates[i] < 0){
                continue;
            }
            solution.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i, solution, result);
            solution.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> list = solution.combinationSum(new int[]{8, 7, 4, 3}, 11);
        list.forEach(System.out::println);
    }

}
