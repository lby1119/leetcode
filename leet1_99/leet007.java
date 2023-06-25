package leet1_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *https://leetcode.cn/problems/1fGaJU/
 * 剑指 Offer II 007. 数组中和为 0 的三个数
 */

public class leet007 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists=new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if(i!=0&&nums[i-1]==nums[i])
                continue;

            int third=nums.length-1;
            for (int j = i+1; j <third ; j++) {
                if(j!=i+1&&nums[j]==nums[j-1])
                    continue;
                while (nums[i]+nums[j]+nums[third]>0 && j<third)
                    third--;

                if(j==third){
                    break;
                }else if(nums[i]+nums[j]+nums[third]==0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[third]);
                    lists.add(list);
                }
//                else if(nums[i]+nums[j]+nums[third]<0){
//
//                }

            }
        }
        return lists;
    }
}
