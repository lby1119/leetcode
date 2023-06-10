package leet2300_2399;

import org.junit.Test;

/**
 *给你两个整数：m 和 n ，表示矩阵的维数。
 * 另给你一个整数链表的头节点 head 。
 * 请你生成一个大小为 m x n 的螺旋矩阵，矩阵包含链表中的所有整数。链表中的整数从矩阵 左上角 开始、顺时针 按 螺旋 顺序填充。如果还存在剩余的空格，则用 -1 填充。
 * 返回生成的矩阵。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/spiral-matrix-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class leet2366 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j]=-1;
            }
        }

        int circle=0;//圈数
    while(true){

        //右
        if((head=spiral(2,circle,circle,n-circle*2,matrix,head))==null) break;

        //下
        if((head=spiral(1,circle+1,circle+n-circle*2-1,m-circle*2-1,matrix,head))==null) break;

        //左
        if((head=spiral(0,m-circle-1,n-circle-2,n-circle*2-1,matrix,head))==null) break;

        //上
        if((head=spiral(3,m-circle-2,n-circle-1-(n-circle*2-1),m-circle*2-2,matrix,head))==null) break;

        circle++;

    }


        return matrix;
    }

    /**
     *
     * @param dir 方向 0左  1下 2右 3上
     * @param i 行
     * @param j 列
     * @param k 最大步数
     * @param matrix
     * @param head
     * @return  移动过后的head
     */
    public ListNode spiral(int dir,int i,int j,int k,int[][] matrix,ListNode head){

        int count;
        if(dir==0){
            for(count=0;count<k;count++)
            {
                if(head!=null){
                    matrix[i][j]=head.val;
                    j--;
                   head = head.next;
                }else return null;
            }


        }else if(dir ==1){
            for(count=0;count<k;count++)
            {
                if(head!=null){
                    matrix[i][j]=head.val;
                    i++;
                    head = head.next;
                }else return null;
            }


        } else if (dir==2) {
            for(count=0;count<k;count++)
            {
                if(head!=null){
                    matrix[i][j]=head.val;
                    j++;
                    head = head.next;
                }else return null;
            }


        } else if (dir==3) {
            for(count=0;count<k;count++)
            {
                if(head!=null){
                    matrix[i][j]=head.val;
                    i--;
                    head = head.next;
                }else return null;
            }

        }

        return head;

    }


    //测试案例
    @Test
    public void test01(){
        int m=3;
        int n=5;
        int[] f={0,2,6,8,1,7,9,4,2,5,5,0};
        ListNode head=new ListNode(3);
        ListNode a=head;
        for(int i:f){
            ListNode b=new ListNode(i);
            a.next=b;
            a=a.next;
        }
        a.next=null;




        spiralMatrix(m,n,head);
        System.out.println("hh");

    }


}
