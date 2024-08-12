package leet200_299;

/**
 * https://leetcode.cn/problems/find-the-duplicate-number/description/?envType=study-plan-v2&envId=top-100-liked
 */

public class leet287 {
    public int findDuplicate(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            sum-=i;
        }
        return sum;
    }
}
