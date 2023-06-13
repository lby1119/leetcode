package leet1_99;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *  https://leetcode.cn/problems/05ZEDJ/
 */

public class leet46 {

    Map<Integer, ArrayList<Integer>> hs=new HashMap<Integer, ArrayList<Integer>>();
    public int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {

        int n=finalCnt.length+1;
        int[] coe=new int[n]; //coe 系数
        int[] con=new int[n];  //con 常数

        for (int i=0;i<finalCnt.length;i++){
            con[i+1]=finalCnt[i];
        }

        coe[0]=1;


        //保存边

        for (int i = 0; i < edges.length; i++) {
            if(hs.containsKey(edges[i][0])){
              hs.get(edges[i][0]).add(edges[i][1]);
            }else {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(edges[i][1]);
                hs.put(edges[i][0],integers);
            }

            if(hs.containsKey(edges[i][1])){
                hs.get(edges[i][1]).add(edges[i][0]);
            }else {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(edges[i][0]);
                hs.put(edges[i][1],integers);
            }

        }

        int planNum;
        int index;
        for (int i = plans.length-1; i >=0 ; i--) {
            planNum=plans[i][0];
            index=plans[i][1];
            getPlan(index,planNum,coe);
            getPlan(index,planNum,con);
        }

        long coeNum=0;
        long conNum=0;

        for (int i = 0; i < n; i++) {
            coeNum+=coe[i];
            conNum+=con[i];
        }

        long x=(totalNum-conNum)/coeNum;

        int[] newNum=new int[n];
        for (int i = 0; i < n; i++) {
            newNum[i]= (int)(coe[i]*x+con[i]);
        }
        return newNum;

    }

    public void getPlan(int index,int planNum,int[] num){
//       1 将编号为 idx 的场馆内的志愿者人数减半；
        if(planNum==1){
            num[index]*=2;
        }else if(planNum==2){
            if(hs.containsKey(index)) {
                ArrayList<Integer> integers = hs.get(index);
                for (int k = 0; k < integers.size(); k++) {
                    num[integers.get(k)] -= num[index];
                }
            }
        } else if (planNum==3) {
            if(hs.containsKey(index)) {
                ArrayList<Integer> integers = hs.get(index);
                for (int k = 0; k < integers.size(); k++) {
                    num[integers.get(k)] += num[index];
                }
            }
        }

//       2将编号为 idx 的场馆相邻的场馆的志愿者人数都加上编号为 idx 的场馆的志愿者人数；
//       3 将编号为 idx 的场馆相邻的场馆的志愿者人数都减去编号为 idx 的场馆的志愿者人数。



    }

    @Test
    public void test(){
//        finalCnt = [1,16], totalNum = 21, edges = [[0,1],[1,2]], plans = [[2,1],[1,0],[3,0]]
    int[] finalcnt={1,16};
    int totalNum=21;
    int[][] edges={{0,1},{1,2}};
    int[][] plans={{2,1},{1,0},{3,0}};
    volunteerDeployment(finalcnt,totalNum,edges,plans);



    }


}
