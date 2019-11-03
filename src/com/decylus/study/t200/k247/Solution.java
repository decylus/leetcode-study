package com.decylus.study.t200.k247;

import java.util.*;

/**
 * Created on 2019-10-31.
 *
 * @author jiawei
 */
public class Solution {

    String[] single = new String[]{"0", "1", "8"};
    String[] doub = new String[]{"11", "69", "88", "96"};

    public List<String> findStrobogrammatic(int n) {

        return new ArrayList<>(find(n, n));
    }

    public Set<String> find(int n, int finalN) {
        Set<String> result = new HashSet<>();
        if (n == 0){
            return result;
        }
        if (n == 1){
            Collections.addAll(result, single);
            return result;
        }else if (n == 2){
            Collections.addAll(result, doub);
            return result;
        }


        Set<String> lastResult = find(n - 2, finalN);
        for (int i = n==finalN?1:0; i < single.length; i++){
            for (String rs : lastResult){
                result.add(single[i] + rs + single[i]);
            }
        }
        for (int i = n==finalN?1:0; i < doub.length; i++){
            for (String rs : lastResult){
                result.add(doub[i].charAt(0) + rs + doub[i].charAt(1));
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.findStrobogrammatic(3);
        result.forEach(System.out::println);
    }
}
