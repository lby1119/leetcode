package leet1_99;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/2AoeFn/
 * 剑指 Offer II 098. 路径的数目
 * 第98题
 */

public class leet98 {




    @Test
    public void test() {
        System.out.println(uniquePaths(19,13));
    }


    public int uniquePaths(int m, int n){

        if(m==1||n==1)
            return 1;

        int[][] paths = new int[m][n];
        for (int i = 0; i < n; i++) {
            paths[m-1][i]=1;
        }

        for (int i = 0; i < m; i++) {
            paths[i][n-1]=1;
        }

        for (int i = m-2; i >=0 ; i--) {
            for (int j = n-2; j >=0 ; j--) {
                paths[i][j]=paths[i+1][j]+paths[i][j+1];
            }
        }
        return paths[0][0];

    }
//    int count = 0;
//    public int uniquePaths(int m, int n) {
//
//        int[][] paths = new int[m][n];
//        paths[m-1][n-1] = -1;
//        return getPath(paths, 0, 0, m, n);
//
//    }
//
//    public int getPath(int[][] paths, int i, int j, int m, int n) {
//
//        if (paths[i][j] == -1) {
//            return 1;
//        }
//
//        int getcount = 0;
//        //向右
//        if (j + 1 < n ) {
//            getcount += getPath(paths, i, j + 1, m, n);
//        }
//
//        if (i + 1 < m ) {
//            getcount += getPath(paths, i + 1, j, m, n);
//        }
//        return getcount;
//    }
}
