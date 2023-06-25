package leet1700_1799;

import org.junit.Test;

/**
 *https://leetcode.cn/problems/closest-subsequence-sum/
 * 1755. 最接近目标值的子序列和
 */

public class leet1755 {


    @Test
    public void test(){
        int[] nums = {5,-7,3,5};
        int goal = 6;
        System.out.println(minAbsDifference(nums,goal));

    }
    public int minAbsDifference(int[] nums, int goal) {

        int size= nums.length;
        int[][] minAbs=new int[size][2];
        minAbs[0][0]=Math.abs(nums[0]-goal);
        minAbs[0][1]=nums[0];

        int minindex;
        for(int i=1;i<size;i++){
            minindex=minIndex(minAbs[i-1][0],Math.abs(minAbs[i-1][1]+nums[i]-goal),Math.abs(nums[i]-goal));
            switch (minindex){
                case 1:
                    minAbs[i][0]=minAbs[i-1][0];
                    minAbs[i][1]=minAbs[i-1][1];
                    break;
                case 2:
                    minAbs[i][0]=Math.abs(minAbs[i-1][1]+nums[i]-goal);
                    minAbs[i][1]=minAbs[i-1][1]+nums[i];
                    break;
                case 3:
                    minAbs[i][0]=Math.abs(nums[i]-goal);
                    minAbs[i][1]=nums[i];
                    break;
            }

        }
        return minAbs[size-1][0];
    }

    public int minIndex(int a,int b,int c){
        if(a<=b&&a<=c){
            return 1;
        } else if (b<=a&&b<=c) {
            return 2;
        }else return 3;

    }


}
