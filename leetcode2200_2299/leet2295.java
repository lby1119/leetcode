package leetcode2200_2299;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */

public class leet2295 {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int n= nums.length;
        int m=operations.length;
        Map<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < m; i++) {
            int a=operations[i][0];
            Integer index = map.get(a);
            nums[index]=operations[i][1];
            map.put(operations[i][1],index);
        }

        return nums;
    }
}
