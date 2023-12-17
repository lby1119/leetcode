package leet1500_1599;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel/
 */

public class leet1599 {

    @Test
    public void test() {
        int[] customers = {3,4,0,5,1};
        int boardingCost = 1, runningCost = 92;
        System.out.println(minOperationsMaxProfit(customers, boardingCost, runningCost));
    }

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int minIndex = Integer.MAX_VALUE, maxSum = -1;
        int personNum = 0, waitNum = 0;
        for (int i = 0; ; i++) {
            if(i<customers.length)
                waitNum += customers[i];
            if (waitNum >= 4) {
                personNum += 4;
                waitNum -= 4;
            } else {
                personNum += waitNum;
                waitNum = 0;
            }
            int sum = personNum * boardingCost - (i + 1) * runningCost;
            if (sum > maxSum) {
                minIndex = i + 1;
                maxSum = sum;
            }
            if (i >= customers.length && waitNum == 0)
                break;
        }
        if (maxSum <= 0)
            return -1;
        else return minIndex;
    }
}
