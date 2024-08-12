package leet200_299;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/perfect-squares/description/?envType=study-plan-v2&envId=top-100-liked
 */

public class leet279 {
    @Test
    public void test(){
        System.out.println(numSquares(13));
    }

    public boolean isSquare(int num) {
        double a = 0;
        try {
            a = Math.sqrt(num);
        } catch (Exception e) {
            return false;
        }
        int b = (int) a;
        return a - b == 0;
    }
    public int numSquares(int n) {
        int[] sumNums=new int[n+1];
        for (int i = 1; i < n+1; i++) {
            boolean square = isSquare(i);
            if(square){
                sumNums[i]=1;
            }else {
                sumNums[i]=Integer.MAX_VALUE;
                for (int j = 1; j <=i/2; j++) {
                    sumNums[i]=Math.min(sumNums[i],sumNums[j]+sumNums[i-j]);
                }
            }
        }
        return sumNums[n];
    }
}
