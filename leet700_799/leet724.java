package leet700_799;

import org.junit.Test;

/**
 *
 *https://leetcode.cn/problems/find-pivot-index/description/
 * 724. 寻找数组的中心下标
 */

public class leet724 {

    @Test
    public void test(){
        int[] nums = {2, 1, -1};
        System.out.println(pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }

        int leftSum=0;
        int rightSum=sum;

        int i=0;
        while (i<nums.length){
            rightSum-=nums[i];
            if(leftSum==rightSum){
                return i;
            }
            leftSum+=nums[i];

            i++;
        }

        return -1;
    }
}
