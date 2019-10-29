package com.decylus.study.t200.k215;

import java.util.Random;

/**
 * Created on 2019-10-29.
 *
 * @author jiawei
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1){
            return nums[0];
        }
        return split(nums, 0, nums.length - 1, k);
    }


    private int split(int[] nums, int left, int right, int k){
        if (left == right){
            return nums[left];
        }
        int s = new Random().nextInt(right - left) + left;
        swap(nums, s, right);
        int i = left;
        int j = left;
        while(j < right) {
            if (nums[j] > nums[right]) {
                swap(nums, i, j);
                i += 1;
            }
            j += 1;
        }
        swap(nums, i, right);
        if (i == k - 1){
            return nums[i];
        }
        if (i < k - 1){
            return split(nums, i, right, k);
        }
        return split(nums, left, i, k);

    }

    private void swap(int[] nums, int x, int y){
        int i = nums[x];
        nums[x] = nums[y];
        nums[y] = i;
    }

    public static void main(String[] args) {
        int[] param = new int[]{-1, -2, -9, 0};
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(param, 2));
    }
}
