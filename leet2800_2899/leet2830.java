package leet2800_2899;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/maximize-the-profit-as-the-salesman/description/
 */

public class leet2830 {

    @Test
    public void  test(){
       //以 n = 5, offers = [[0,0,1],[0,2,2],[1,3,2]] 构造maximizeTheProfit的输入
        List<List<Integer>> offers=new ArrayList<>();
        List<Integer> off1=new ArrayList<>();
        off1.add(0);
        off1.add(0);
        off1.add(1);
        offers.add(off1);
        List<Integer> off2=new ArrayList<>();
        off2.add(0);
        off2.add(2);
        off2.add(2);
        offers.add(off2);
        List<Integer> off3=new ArrayList<>();
        off3.add(1);
        off3.add(3);
        off3.add(2);
        offers.add(off3);
        int n=5;
        int maximizeTheProfit = maximizeTheProfit(n, offers);
        System.out.println(maximizeTheProfit);
    }


    public int getMax(List<List<Integer>> offers,Map<Integer, List<List<Integer>>> map,int i,int[] dp){
        int maxProfit=0;
        List<List<Integer>> list = map.getOrDefault(i, new ArrayList<>());
        for(List<Integer> off:list){
            maxProfit=Math.max(maxProfit,dp[off.get(0)]+off.get(1));
        }
        return maxProfit;
    }
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        for (List<Integer> offer : offers) {
            List<List<Integer>> list = map.getOrDefault(offer.get(1), new ArrayList<>());
            List<Integer> off = new ArrayList<>();
            off.add(offer.get(0));
            off.add(offer.get(2));
            list.add(off);
            map.put(offer.get(1), list);
        }

        int[] dp=new int[n+1];
        dp[0]=0;
        for (int i = 1; i < n+1; i++) {
            dp[i]=Math.max(dp[i-1],getMax(offers,map,i-1,dp));
        }
        return dp[n];

    }
}
