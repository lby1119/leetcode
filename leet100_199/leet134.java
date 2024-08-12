package leet100_199;

import org.junit.Test;

/**
 *
 */

public class leet134 {

    @Test
    public void test(){
        int[] gas = {2,3,4};
        int[]  cost = {3,4,3};
        System.out.println(canCompleteCircuit(gas,cost));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int sumGas;
        int costGas;
        int j;
        int i=0;
        int n=gas.length;
        while(i<n){
            j=i;
            sumGas=gas[j];
            costGas=cost[j];
            int k = j;
            if(sumGas>=costGas){
                while(sumGas>=costGas){
                    j = (j+1)%n;
                    sumGas+=gas[j];
                    costGas+=cost[j];
                    k = Math.max(k,j);
                    if(i==j){
                        return i;
                    }
                }
                i = k+1;
            }else {
                i++;
            }

        }
        return -1;
    }
}
