package com.decylus.study.t000.k091;

/**
 * Created on 2019-10-30.
 *
 * Circular
 *
 * 2ms 34.1mb
 *
 * @author jiawei
 */
public class Solution2 {

    public int numDecodings(String s) {
        int[] history = new int[s.length() + 1];
        if (s.length() == 0 || s.charAt(0) == '0' || (s.charAt(1) == '0' && s.charAt(0) > '2')){
            return 0;
        }
        if (s.contains("00")){
            return 0;
        }
        //history start with 1 (not 0), the history[0] is a extra number to unify the method
        history[0] = 1;
        history[1] = 1;
        for (int i = 2; i <= s.length(); i++){
            if (s.charAt(i - 1) == '0' && s.charAt(i - 2) >= '3'){
                break;
            }
            if (s.charAt(i - 1) == '0' && s.charAt(i - 2) <= '2'){
                history[i] = history[i - 2];
            }else if (s.charAt(i - 2) == '0'){
                history[i] = history[i-1];
            }else if (s.charAt(i - 1) >= '7' && s.charAt(i - 2) >= '2'){
                history[i] = history[i-1];
            }else if (s.charAt(i - 2) >= '3'){
                history[i] = history[i-1];
            }else{
                history[i] = history[i-1] + history[i-2];
            }
        }
        return history[s.length()];
    }


    public static void main(String[] args) {
        String s = "226211";
        System.out.println(new Solution2().numDecodings(s));
    }
}
