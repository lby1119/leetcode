package leet100_199;

/**
 *https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked
 */

public class leet153 {
    public int findMin(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.min(nums[0],nums[1]);
        if(nums[n-1]>nums[0]) return nums[0];
        if (nums[n-1]<nums[n-2]) return nums[n-1];

        int left=0,right=n-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]>nums[left]) left=mid;
            else if(nums[mid]>nums[mid-1]) right=mid;
            else return nums[mid];

        }
        return 0;

    }
}
