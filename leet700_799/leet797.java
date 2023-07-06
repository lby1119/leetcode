package leet700_799;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *https://leetcode.cn/problems/all-paths-from-source-to-target/
 * 797. 所有可能的路径
 */

public class leet797 {

    @Test
    public void test(){
//        int[][] graph={{1,2},{3},{3},{}};
//        int[][] graph={{ 4,3,1},{3,2,4},{3},{4},{}};
        int[][] graph={{ 4,3,1},{3,2,4},{},{4},{}};

        List<List<Integer>> lists = allPathsSourceTarget(graph);
        for(List list:lists){
            System.out.println(list);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> lists=new ArrayList<>();
        int n=graph.length;

        for (int i = 0; i < graph[0].length; i++) {
            List<Integer> list=new ArrayList<>();
            list.add(0);
            getList(graph,graph[0][i],n,list,lists);
        }

        return lists;
    }

    public void getList(int[][] graph,int i,int n,List<Integer> list,List<List<Integer>> lists){
        list.add(i);
        if(i==n-1){

            List<Integer> newList=new ArrayList<>();
            newList.addAll(list);
            lists.add(newList);
            list.remove(list.size()-1);
            return;
        }

        if(graph[i].length==0){
            list.remove(list.size()-1);
            return;
        }


        for (int j = 0; j < graph[i].length; j++) {
            getList(graph,graph[i][j],n,list,lists);

        }

        list.remove(list.size()-1);

    }
}
