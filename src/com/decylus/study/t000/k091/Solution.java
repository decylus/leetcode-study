package com.decylus.study.t000.k091;

/**
 * Created on 2019-10-30.
 *
 * recursion
 * 11ms  34.2mb
 * the solution2 is faster than this
 *
 * @author jiawei
 */
public class Solution {

    public int numDecodings(String s) {
        int[] countHistory = new int[s.length()];
        char[] nums = s.toCharArray();
        if (nums.length == 0) {
            return 0;
        }
        return decode(nums, 0, countHistory);
    }

    private int decode(char[] nums, int start, int[] history) {
        if (start <= nums.length - 1 && nums[start] == '0') {
            return 0;
        }
        if (start >= nums.length - 1) {
            return 1;
        }

        if (history[start] != 0) {
            return history[start];
        }
        int count = 0;

        //f(n) = f(n-1) + f(n-2)
        count += decode(nums, start + 1, history);

        if (start + 1 < nums.length
                && (nums[start] < '2' || nums[start] == '2' && nums[start + 1] < '7')) {
            count += decode(nums, start + 2, history);
        }

        history[start] = count;
        return count;
    }


    public static void main(String[] args) {
        String s = "226211";
        System.out.println(new Solution().numDecodings(s));
    }
}
