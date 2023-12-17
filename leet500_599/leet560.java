package leet500_599;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */

public class leet560 {
    @Test
    public void test(){

        int[] nums={-1,-1,1};
        int k=1;
        System.out.println(subarraySum(nums,k));
    }

    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        int count=0;
        Map<Integer,Integer> map =new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
