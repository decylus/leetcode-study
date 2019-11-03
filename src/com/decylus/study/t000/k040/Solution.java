package com.decylus.study.t000.k040;

import java.util.*;

/**
 * Created on 2019-11-03.
 *
 * 4ms, 36.7mb
 *
 * @author jiawei
 */
public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Deque<Integer> solution = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);
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
            if(i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            solution.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i + 1, solution, result);
            solution.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] c = new int[]{10,1,2,7,6,1,5};
        Solution solution = new Solution();
        List<List<Integer>> list = solution.combinationSum2(c, 8);
        list.forEach(System.out::println);
    }
}
