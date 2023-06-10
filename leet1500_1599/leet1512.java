package leet1500_1599;

import java.util.HashMap;

public class leet1512 {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> has=new HashMap<>();
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if (has.containsKey(nums[i])) {
                has.put(nums[i], has.get(nums[i]) + 1);
            } else {
                has.put(nums[i], 1);
            }
        }

        for (Integer key: has.keySet()) {
            for (int i=0;i<has.get(key);i++){
                count+=i;
            }
        }
        return count;
    }
}

