package leet1900_1999;

/**
 *https://leetcode.cn/problems/maximum-alternating-subsequence-sum/
 *1911. 最大子序列交替和
 */

public class leet1911 {


    public long maxAlternatingSum(int[] nums) {
        /**
         * odd 奇数
         * even 偶数
         */
        long odd=0;
        long even=0;

        for (int num: nums){
            long even1=even;
            long odd1=odd;

            even=Math.max(even1,odd1+num);
            odd=Math.max(odd1,even1-num);
        }

        return even; 

    }
}
