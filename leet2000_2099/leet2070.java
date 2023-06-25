package leet2000_2099;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *https://leetcode.cn/problems/most-beautiful-item-for-each-query/
 * 2070. 每一个查询的最大美丽值
 */

public class leet2070 {
    @Test
    public void test(){
        int[][] items={{10,100}};
        int[] queries={5};
       maximumBeauty(items,queries);
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {

        int[][] item = getItem(items);
        int size=item.length;
        int[] answers=new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answers[i]=getBeauty(item,queries,queries[i],size);
        }


        return answers;
    }

    public int[][] getItem(int[][] items) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            map.put(items[i][0], map.getOrDefault(items[i][0], 0) < items[i][1] ? items[i][1] : map.getOrDefault(items[i][0], 0));
        }
        int size= map.size();
        int[][] beauties=new int[size][2];
        int i=0;
        for (Integer key: map.keySet()) {
            beauties[i][0]=key;
            beauties[i][1]=map.getOrDefault(key,0);
            i++;
        }

        Arrays.sort(beauties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for (int j = 0; j < beauties.length-1; j++) {
            if(beauties[j+1][1]<beauties[j][1]){
                beauties[j+1][1]=beauties[j][1];
            }
        }
        return beauties;
    }

    public int getBeauty(int[][] item,int[] queries,int k,int size){
        int l = 0, r = size;
        while (l < r){
            int mid = l + (r - l) / 2;
            if (item[mid][0] > k){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        if (l == 0){
            // 此时所有物品价格均大于查询价格
            return 0;
        }
        else{
            // 返回小于等于查询价格的物品的最大美丽值
            return item[l-1][1];
        }


    }
}

