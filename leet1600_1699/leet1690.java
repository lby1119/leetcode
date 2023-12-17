package leet1600_1699;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/stone-game-vii/
 */

public class leet1690 {

    @Test
    public void test(){
        int[] stones={5,3,1,4,2};
        System.out.println(stoneGameVII(stones));
    }


    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[][] sum=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j <n ; j++) {
                if(j==i) sum[i][j]=stones[i];
                else sum[i][j]=sum[i][j-1]+stones[j];
            }
        }

        int[][] dp=new int[n][n];
        for (int i = n-1; i >=0 ; i--) {
            for (int j = i+1; j < n; j++) {
                dp[i][j]=Math.max(sum[i + 1][j] - dp[i + 1][j], sum[i][j - 1] - dp[i][j - 1]);
            }

        }
        return dp[0][n-1];
    }


}
