package com.decylus.study.t300.k315;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 2019-10-29.
 *
 * merge-sort
 * 归并排序解法
 * 6ms  39.1mb
 *
 * @author jiawei
 */
public class Solution2 {

    private int[] nums;

    private int[] count;

    public List<Integer> countSmaller(int[] nums) {
        this.nums = nums;
        int[] indexArray = new int[nums.length];
        this.count = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            indexArray[i] = i;
        }
        int[] temp = new int[nums.length];
        mergeSort(indexArray, temp, 0, indexArray.length-1);
        return Arrays.stream(count).boxed().collect(Collectors.toList());
    }

    private void mergeSort(int[] indexArray, int[] result, int left, int right){
        if (left >= right){
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(indexArray, result, left, mid);
        mergeSort(indexArray, result, mid + 1, right);
        int l = left;
        int r = mid + 1;
        int i = left;
        while(l <= mid && r <= right){
            if (nums[indexArray[l]] > nums[indexArray[r]]){
                result[i] = indexArray[l];
                count[indexArray[l]] += right - r + 1;
                l += 1;
            }else{
                result[i] = indexArray[r];
                r += 1;
            }
            i += 1;
        }
        while (l <= mid){
            result[i] = indexArray[l];
            l += 1;
            i += 1;
        }
        while (r <= right){
            result[i] = indexArray[r];
            r += 1;
            i += 1;
        }
        for(i = left; i <= right; i++) {
            indexArray[i] = result[i];
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = new int[]{-1,-2,-1};
        List<Integer> result = solution2.countSmaller(nums);
        result.forEach(i -> System.out.println(i));
    }
}
