package leet_interview_08;

import org.junit.Test;

import java.util.HashMap;

/**
 * 颜色填充
 * https://leetcode.cn/problems/color-fill-lcci/
 */

public class leet10 {


    @Test
    public void test(){
        int[][] image={{1,1,1},{1,1,0},{1,0,1}};
        image=floodFill(image,1,1,2);
        for (int i = 0; i < image.length; i++) {
            for (int i1 = 0; i1 < image[0].length; i1++) {
                System.out.print(image[i][i1]+" ");
            }
            System.out.println();
        }
    }
    HashMap<String,Integer> hs=new HashMap<>();
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int numLine=image.length;
        int numCol=image[0].length;
        recursion(image,sr,sc,newColor,numLine,numCol,image[sr][sc]);
        return image;
    }

    public void recursion(int[][] image,int sr,int sc,int newColor,int numLine,int numCol,int initColor){

        if(image[sr][sc]!=initColor)
            return;

        image[sr][sc]=newColor;
        hs.put(sr+" "+sc,1);

        //点右边
        if(sc+1<numCol&&!hs.containsKey(sr+" "+(sc+1))){
            recursion(image,sr,sc+1,newColor,numLine,numCol,initColor);
        }

        //点下边
        if(sr+1<numLine&& !hs.containsKey((sr+1)+" "+sc)){
            recursion(image,sr+1,sc,newColor,numLine,numCol,initColor);
        }

        //点左边
        if(sc-1>=0&&!hs.containsKey(sr+" "+(sc-1))){
            recursion(image,sr,sc-1,newColor,numLine,numCol,initColor);
        }

        //点上边
        if(sr-1>=0&&!hs.containsKey((sr-1)+" "+sc)){
            recursion(image,sr-1,sc,newColor,numLine,numCol,initColor);
        }


    }
}
