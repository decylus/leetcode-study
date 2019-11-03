package com.decylus.study.t200.k260;

import java.util.Arrays;

/**
 * Created on 2019-11-03.
 *
 * 4ms, 38.5mb
 *
 * @author jiawei
 */
public class Solution2 {
    public int[] singleNumber(int[] nums) {

        int[] result = new int[2];
        Arrays.sort(nums);
        int j = 0;
        boolean flag = false;
        for (int i = 1; i <= nums.length; i+=1) {
            if (j > 1){
                break;
            }
            if (i == nums.length && flag){
                result[j] = nums[i-1];
                break;
            }

            if (nums[i] != nums[i-1] && i - 1 == 0){
                result[j] = nums[i-1];
                flag = true;
                j++;
                continue;
            }
            if (nums[i] != nums[i-1] && flag){
                result[j] = nums[i-1];
                j++;
            }
            flag = nums[i] != nums[i - 1];
        }
        return result;

    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] result = solution.singleNumber(new int[]{1,2,1,3,2,5});
        for (int i : result) {
            System.out.println(i);
        }

    }
}
