package com.decylus.study.t400.k414;

import java.util.TreeSet;

/**
 * Created on 2019-10-30.
 *
 * 47ms 37.3mb
 *
 * @author jiawei
 */
public class Solution {

    public int thirdMax(int[] nums) {

        //tree set has a log(n) performance on add and remove
        TreeSet<Integer> treeSet = new TreeSet<>((a, b) -> -Integer.compare(a, b));
        // O(n*2*log(3)) = O(n)
        for(int num : nums){
            treeSet.add(num);
            if (treeSet.size() > 3){
                treeSet.remove(treeSet.last());
            }
        }
        return treeSet.size()==3?treeSet.last():treeSet.first();
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE - 1);
        int[] nums = new int[]{Integer.MIN_VALUE,1,1};
        System.out.println(new Solution().thirdMax(nums));
    }
}
