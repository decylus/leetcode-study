package com.decylus.study.t300.k315;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 2019-10-28.
 *
 * SegmentTree
 * 线段树解法
 * 23ms  39.1mb
 *
 * @author jiawei
 */
public class Solution {

    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0){
            return new ArrayList<>();
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums){
            if (num > max){
                max = num;
            }
            if (num < min){
                min = num;
            }
        }

        SegmentTree tree = new SegmentTree(min, max);
        List<Integer> result = new LinkedList<>();

        for(int i = nums.length - 1; i >=0; i--){
            result.add(tree.get(Integer.MIN_VALUE, nums[i] - 1));
            tree.add(nums[i]);
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] param = new int[]{101,0,-19,-1,21,84,66,65,36,100,41};
        Solution solution = new Solution();
        List<Integer> list = solution.countSmaller(param);
        list.forEach(l -> System.out.println(l));
    }
}
