package leet1_99;

import org.junit.Test;

import java.util.Arrays;

/**
 *https://leetcode.cn/problems/7WqeDu/description/
 * LCR 057. 存在重复元素 III
 */

public class leet57 {
    @Test
    public void test(){
        int[] num={1,5,9,1,5,9};
        System.out.println(containsNearbyAlmostDuplicate(num,2,3));
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Arrays.sort(nums);
        for (int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]<=t&&1<=k)
                return true;
        }
        return false;
    }
}
