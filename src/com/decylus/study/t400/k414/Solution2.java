package com.decylus.study.t400.k414;


/**
 * Created on 2019-10-30.
 *
 * 1ms 38mb
 *
 * @author jiawei
 */
public class Solution2 {

    public int thirdMax(int[] nums) {
        int[] b3 = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        boolean hasMin = false;
        for (int num : nums){
            if (num == Integer.MIN_VALUE){
                hasMin = true;
            }
            if (num > b3[0]){
                b3[2] = b3[1];
                b3[1] = b3[0];
                b3[0] = num;
            }else if (num > b3[1]){
                if(num == b3[0]){
                    continue;
                }
                b3[2] = b3[1];
                b3[1] = num;
            }else if (num > b3[2]){
                if(num == b3[1]){
                    continue;
                }
                b3[2] = num;
            }
        }
        if(b3[1] == Integer.MIN_VALUE){
            return b3[0];
        }
        if(b3[2] == Integer.MIN_VALUE && !hasMin){
            return b3[0];
        }

        return b3[2];
    }
}
