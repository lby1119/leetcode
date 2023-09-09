package leet1900_1999;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */

public class leet1962 {
    @Test
    public void test(){
        int[] piles={5,4,9};
        int k=2;
        System.out.println(minStoneSum(piles,k));
    }


    public int minStoneSum(int[] piles, int k) {
        int sum = 0;
        Arrays.sort(piles);
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i];
        }
        Queue<Integer> queue=new LinkedList<>();
        int index= piles.length-1;
        for (int i = 0; i < k; i++) {
            if(queue.size()!=0&&index>=0){
                int pile=piles[index];
                int pop=queue.peek();
                if(pile>pop){
                    sum-= pile/2;
                    index--;
                    queue.add(pile-pile/2);
                }else {
                    sum-=pop/2;
                    queue.remove();
                    queue.add(pop-pop/2);
                }
            }else if(queue.size()!=0){
                int pop= queue.remove();
                sum-=pop/2;
                queue.add(pop-pop/2);
            }else {
                int pile=piles[index];
                sum-= pile/2;
                index--;
                queue.add(pile-pile/2);
            }
        }

        return sum;
    }
}
