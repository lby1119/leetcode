package leet2600_2699;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 *
 */

public class leet2644 {

    public static void main(String[] args) {
//[56,22,79,41,8,39,81,59,74,14,45,49,15,10,28,16,77,22,65,8,36,79,94,44,80,72,8,96,78]
//[39,92,69,55,9,44,26,76,40,77,16,69,40,64,12,48,66,7,59,10,33,72,97,60,79,68,25,63]
//        int[] nums={56,22,79,41,8,39,81,59,74,14,45,49,15,10,28,16,77,22,65,8,36,79,94,44,80,72,8,96,78};
//        int[] div={39,92,69,55,9,44,26,76,40,77,16,69,40,64,12,48,66,7,59,10,33,72,97,60,79,68,25,63};

        int[] nums={4,7,9,3,9};
       int[] div={5,2,3};
        System.out.println(new leet2644().maxDivScore(nums,div));
    }

    @Test
    public void test(){
        ArrayList<Integer> integers=new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(4);
        integers.add(3);
        integers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (Integer in:integers
             ) {
            System.out.println(in);
        }
    }

/**
*  优化
* */
public int maxDivScoreMax(int[] nums, int[] divisors) {
    int maxScore=0;
    int minNum=Integer.MAX_VALUE;
    int count;
    for (int i = 0; i < divisors.length; i++) {
        count=0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]%divisors[i]==0){
                count++;
            }
        }
        if(maxScore<count){
            maxScore=count;
            minNum=divisors[i];
        }else if(maxScore==count&&minNum>divisors[i]){
            minNum=divisors[i];
        }

    }


    return minNum;

}


    public int maxDivScore(int[] nums, int[] divisors) {
        int maxScore=0;
        int count;
        HashMap<Integer, ArrayList<Integer>> hm=new HashMap<>();
        for (int i = 0; i < divisors.length; i++) {
            count=0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[j]%divisors[i]==0){
                    count++;
                }
            }
            if(maxScore<=count){
                maxScore=count;
                if(hm.containsKey(maxScore)){
                    hm.get(maxScore).add(divisors[i]);
                }else {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(divisors[i]);
                    hm.put(maxScore,integers);
                }
            }

        }

        ArrayList<Integer> integers = hm.get(maxScore);
        if (integers.size() != 1) {
            integers.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
        }
        return integers.get(0);

    }
}
