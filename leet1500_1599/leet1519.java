package leet1500_1599;

import java.util.*;

public class leet1519 {
    public static void main(String[] args) {
//        5
//        [[0,1],[1,2],[2,3],[2,4]]
//        "cbfef"

//        4
//        [[0,2],[0,3],[1,2]]
//        "aeed"
        int n=4;
        int[][] edges={{0,2},{0,3},{1,2}};
        String s="aeed";
        int[] num=new leet1519().countSubTrees(n,edges,s);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]+" ");
        }
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {

        ArrayList<ArrayList<Integer>> arrayLists=new ArrayList<>();
        ArrayList<Integer> arr=null;
        for (int i = 0; i <n-1 ; i++) {
            arr=new ArrayList<>();
            arr.add(edges[i][0]);
            arr.add(edges[i][1]);
           arrayLists.add(arr);
        }

        int[][] num=new int[n][26];

        char[] chars = labels.toCharArray();

        Queue<Integer> qu=new LinkedList<>();
        Stack<Integer> st=new Stack<>();
        HashMap<Integer,String> hs=new HashMap<>();
        qu.add(0);

        while (qu.size()!=0){
            int k= qu.poll();

            if(!hs.containsKey(k)){
                hs.put(k,"");
                st.add(k);
                for (int i = 0; i < arrayLists.size(); i++) {
                    if(arrayLists.get(i).get(0)==k&&!hs.containsKey(arrayLists.get(i).get(1))){
                        qu.add(arrayLists.get(i).get(1));
                        if(hs.get(k).equals("")){
                            hs.put(k,arrayLists.get(i).get(1)+"");
                        }else {
                            hs.put(k, hs.get(k)+" "+arrayLists.get(i).get(1));
                        }
                        arrayLists.remove(i);
                        i--;

                    }else if(arrayLists.get(i).get(1)==k&&!hs.containsKey(arrayLists.get(i).get(0))){
                        qu.add(arrayLists.get(i).get(0));
                        if(hs.get(k).equals("")){
                            hs.put(k,arrayLists.get(i).get(0)+"");
                        }else {
                            hs.put(k, hs.get(k)+" "+arrayLists.get(i).get(0));
                        }
                        arrayLists.remove(i);
                        i--;
                    }
                }
            }

        }

        while (st.size()!=0){
            int i=st.pop();
            num[i][chars[i]-'a']++;

            String s=hs.get(i);
            if(!s.equals("")){
                String[] s1 = s.split(" ");
                for (int j = 0; j <s1.length ; j++) {
                    int j1=Integer.parseInt(s1[j]);
                    for (int k = 0; k < 26; k++) {

                        num[i][k]+=num[j1][k];
                    }
                }
            }


        }



        int[] number=new int[n];
        for (int i = 0; i < n; i++) {
            number[i]=num[i][chars[i]-'a'];
        }
        return number;

    }


}
