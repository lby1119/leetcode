package leet1_99;

/**
 *https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/
 * 剑指 Offer 63. 股票的最大利润
 */

public class leet63 {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        if(prices.length<2)
            return 0;
        int min=prices[0];
        for (int i = 1; i <prices.length ; i++) {
            maxProfit=Math.max(maxProfit,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return maxProfit;
    }
}
