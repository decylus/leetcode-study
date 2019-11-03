package com.decylus.study.t200.k260;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on 2019-11-03.
 *
 * @author jiawei
 */
public class Solution {
    public int[] singleNumber(int[] nums) {

        Set<Integer> numsList = new HashSet<>(nums.length/2 + 2);
        for (int num : nums){
            if (numsList.contains(num)){
                numsList.remove(num);
            }else{
                numsList.add(num);
            }
        }
        int[] result = new int[2];
        int i = 0;
        for (Integer integer : numsList) {
            result[i] = integer;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.singleNumber(new int[]{1,2,1,3,2,5});
        for (int i : result) {
            System.out.println(i);
        }

    }
}
