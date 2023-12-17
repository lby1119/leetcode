package leet800_899;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *https://leetcode.cn/problems/loud-and-rich/ 851. 喧闹和富有
 */

public class leet851 {

    public void dfs(int x,List<List<Integer>> riches,int[] ans, int[] quiet){
        if(ans[x]!=-1){
            return;
        }

        ans[x]=x;
        for(Integer y:riches.get(x)){
            dfs(y,riches,ans,quiet);
            if(quiet[ans[x]]>quiet[ans[y]]){
                ans[x]=ans[y];
            }
        }
    }


    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n=quiet.length;
        List<List<Integer>> riches= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            riches.add(new ArrayList<Integer>());
        }
        for (int[] rich : richer) {
            riches.get(rich[1]).add(rich[0]);
        }
        int[] ans=new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            dfs(i,riches,ans,quiet);

        }
        return ans;

    }
    @Test
    public void test() {
        int[][] richer= {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet = {3,2,5,4,6,1,7,0};
        loudAndRich(richer,quiet);
    }
}
