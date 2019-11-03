package com.decylus.study.t200.k216;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 2019-11-03.
 *
 * 1ms, 33.8mb
 *
 * @author jiawei
 */
public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        Deque<Integer> solution = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        backTrack(k, n, 1, solution, result);
        return result;
    }

    private void backTrack(int count, int target, int start, Deque<Integer> solution, List<List<Integer>> result){

        //find the solution
        if (target == 0 && count == solution.size()){
            List<Integer> list = new ArrayList<>(solution);
            result.add(list);
            return;

        }
        for (int i = start; i < 10; i++){
            if (target - i <= 0 && count > solution.size() + 1 ){
                continue;
            }
            solution.add(i);
            backTrack(count, target - i, i + 1, solution, result);
            solution.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> list = solution.combinationSum3(3, 7);
        list.forEach(System.out::println);
    }
}
