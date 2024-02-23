package leet200_299;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/description/?envType=study-plan-v2&envId=top-100-liked
 */

public class leet240 {

    //z字形求解
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
//        return recursion(matrix,target,n,m,0,0);
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) {
                i = i + 1;
            } else {
                j = j - 1;
            }
        }
        return false;
    }


    //递归求解
    public boolean recursion(int[][] matrix, int target, int n, int m, int i, int j) {
        if (matrix[i][j] == target) {
            return true;
        } else if (matrix[i][j] < target) {
            boolean bo = false;
            if (i + 1 < n) {
                bo = recursion(matrix, target, n, m, i + 1, j) || bo;
            }
            if (j + 1 < m) {
                bo = recursion(matrix, target, n, m, i, j + 1) || bo;
            }
            return bo;
        } else return false;
    }
}
