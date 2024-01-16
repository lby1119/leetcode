package leet1_99;

/**
 *
 */

public class main {
    public static void main(String[] args) {
//        在一个m*n的棋盘的每一格都放有一定数量金币，其中每个金币的价值均相同。你可以从棋盘的左上角开始拿格子里的金币，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的金币的数量，请计算你最多能拿到多少价值的金币？
        //输入两个值
        //第一个值是行数
        //第二个值是列数
        //接下来的行数*列数个值是每个格子的金币数量
        //输出一个值，是最多能拿到的金币价值
        int[][] board = new int[][]{{1,3,1},{1,5,1},{4,2,1}};

    }

    public int getMost(int[][] board) {
        for(int i = 0 ; i<board.length ; i++){
            for(int j = 0 ; j <board[0].length ; j++){
                if(i==0&&j==0){
                }else if(i == 0){
                    board[i][j] += board[i][j-1];
                }else if(j == 0){
                    board[i][j] += board[i-1][j];
                }else{
                    int temup = board[i-1][j];
                    int templeft = board[i][j-1];
                    if(temup>templeft){
                        board[i][j] +=temup ;
                    }else{
                        board[i][j] +=templeft;
                    }
                }
            }
        }
        return  board[board.length-1][board[0].length-1];
    }

}
