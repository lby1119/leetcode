package leet1700_1799;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 *
 */

public class leet1743 {
    @Test
    public void test(){
        int[][]  adjacentPairs = {{2,1},{3,4},{3,2}};
        System.out.println(restoreArray(adjacentPairs));
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        int size= adjacentPairs.length;
        Map<Integer, ArrayList<Integer>> map=new HashMap<>();
        for (int i = 0; i < size; i++) {
            int num0=adjacentPairs[i][0];
            int num1=adjacentPairs[i][1];

            if(map.containsKey(num0)){
                ArrayList<Integer> vector=map.get(num0);
                vector.add(num1);
                map.put(num0,vector);
            }else {
                ArrayList<Integer> vector=new ArrayList<>(0);
                vector.add(num1);
                map.put(num0,vector);
            }

            if(map.containsKey(num1)){
                ArrayList<Integer> vector=map.get(num1);
                vector.add(num0);
                map.put(num1,vector);
            }else {
                ArrayList<Integer> vector=new ArrayList<>(0);
                vector.add(num0);
                map.put(num1,vector);
            }

        }

        int n= map.size();
        int[] nums=new int[n];
        int initialNum = 0;
        for (Integer key: map.keySet()) {
            ArrayList<Integer> vector = map.get(key);
            if(vector.size()==1){
                initialNum=key;
                break;
            }
        }

        nums[0]=initialNum;
        for (int i = 1; i < n; i++) {
            ArrayList<Integer> vector = map.get(nums[i - 1]);
            if(vector.size()==1){
                nums[i]=  vector.get(0);
            }else {
                int num0=vector.get(0);
                int num1=vector.get(1);
                if(num0==nums[i-2]){
                    nums[i]=num1;
                }else {
                    nums[i]=num0;
                }
            }
        }

        return nums;
    }
}
