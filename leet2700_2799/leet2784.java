package leet2700_2799;

import java.util.Arrays;

/**
 *https://leetcode.cn/problems/check-if-array-is-good/
 */

public class leet2784 {
    public boolean isGood(int[] nums) {
        //获取数组最大值
        int max= Arrays.stream(nums).max().getAsInt();
        int n=nums.length;
        int[] count=new int[max+1];
        for (int num : nums) {
            count[num]++;
        }
        int i=1;
        while (i<n-1){
            if(count[i]==1){
                i++;
            }else {
                return false;
            }
        }
        return count[i] == 2;

    }
}
