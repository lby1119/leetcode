package leet1_99;

import org.junit.Test;

/**
 *https://leetcode.cn/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-100-liked
 */

public class leet42 {
    @Test
    public void test(){
       int[] nums= {4,2,0,3,2,5};
        System.out.println(trap(nums));
    }

    public int trap(int[] height) {
        int n=height.length;
        int sum=0;
        int[] leftNums=new int[n];
        int[] rightNums=new int[n];

        leftNums[0]=height[0];
        for (int i=1;i<n;i++)
            leftNums[i]=Math.max(leftNums[i-1],height[i]);

        rightNums[n-1]=height[n-1];
        for (int i=n-2;i>=0;i--)
            rightNums[i]=Math.max(rightNums[i+1],height[i]);

        for (int i = 0; i < n; i++) {
            sum+=Math.min(rightNums[i],leftNums[i])-height[i];
        }

        return sum;
    }
}
