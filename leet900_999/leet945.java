package leet900_999;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/minimum-increment-to-make-array-unique/
 * 945. 使数组唯一的最小增量
 */

public class leet945 {

    @Test
    public void test(){
        int[] nums={3,2,1,2,1,7};
        System.out.println(minIncrementForUnique(nums));
    }
    public int minIncrementForUnique(int[] nums) {
        int n=nums.length;
        int minSize=0;
        Arrays.sort(nums);
        for (int i=1;i<n;i++){
            if(nums[i]<=nums[i-1])
            {
                minSize+=nums[i-1]-nums[i]+1;
                nums[i]=nums[i-1]+1;

            }
        }
        return minSize;
    }
}
