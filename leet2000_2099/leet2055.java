package leet2000_2099;

import org.junit.Test;

/**
 *
 */

public class leet2055 {
    @Test
    public void test(){
        String s="***|**|*****|**||**|*";
        int[][] queries = {{1,17},{4,5},{14,17},{5,11}};
        System.out.println(platesBetweenCandles(s,queries));
    }


    public int[] platesBetweenCandles(String s, int[][] queries) {
        int size=s.length();
        char[] charArray = s.toCharArray();

        //preSum[i]代表第个i元素前方共有多少个*（包含第i个元素）
        int[] preSum=new int[size];
        for (int i = 0, sum = 0; i < size; i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            preSum[i] = sum;
        }



        //left[i]表示第i个元素左边离自己最近为‘|’的元素坐标
        //right[i]表示第i个元素右边离自己最近为‘|’的元素坐标

        int left[]=new int[size];
        int right[]=new int[size];
        for (int i = 0, l=-1; i <size ; i++) {
            if(charArray[i]=='|'){
                l=i;
            }
            left[i]=l;
        }
        for (int j = size-1,r=-1; j >=0 ; j--) {
            if(charArray[j]=='|'){
                r=j;
            }
            right[j]=r;
        }

        int num= queries.length;
        int answers[]=new int[num];
        for (int i = 0; i < num; i++) {
            int[] query=queries[i];
            int x=right[query[0]],y=left[query[1]];

            answers[i]=x==-1||y==-1||x>=y?0:preSum[y]-preSum[x];
        }

        return answers;
    }
}
