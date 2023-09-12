package leet100_199;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *https://leetcode.cn/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-100-liked
 */

public class leet128 {
    public int longestConsecutive(int[] nums) {
        int nowNum=0,maxNum=0;
        Set<Integer> num_set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            num_set.add(nums[i]);
        }
        for(Integer num:num_set){
            nowNum=0;
            if(num_set.contains(num-1)){
                continue;
            }else {
                nowNum=1;
                int i=1;
                while(num_set.contains(num+i)){
                    nowNum++;
                    i++;
                }
                maxNum=Math.max(maxNum,nowNum);
            }
        }

        return maxNum;
    }

}
