package leet1_99;

import java.util.*;

/**
 *https://leetcode.cn/problems/two-sum/?envType=study-plan-v2&envId=top-100-liked
 */

public class leet1 {

    public int[] twoSum(int[] nums, int target) {
        int res[]=new int[2];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> orDefault = map.getOrDefault(nums[i], new ArrayList<>());
            orDefault.add(i);
            map.put(nums[i],orDefault);
        }

        for (int i = 0; i < nums.length; i++) {
            List<Integer> orDefault = map.getOrDefault(target - nums[i],new ArrayList<>());
            if(Objects.nonNull(orDefault)&&orDefault.size()>0){
                if(target-nums[i]!=nums[i]){
                    res[0]=i;
                    res[1]=orDefault.get(0);
                }else {
                    if(orDefault.size()>=2){
                        res[0]=orDefault.get(0);
                        res[1]=orDefault.get(1);
                    }
                }
            }

        }
        return res;
    }
}
