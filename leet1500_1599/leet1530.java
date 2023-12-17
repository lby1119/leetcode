package leet1500_1599;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
*  https://leetcode.cn/problems/number-of-good-leaf-nodes-pairs/
 **/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class leet1530 {


        //层序遍历二叉树 叶子节点对于序号加入数组
    public void levelOrder(TreeNode root,List<Integer> arr,int index) {

        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            arr.add(index);
            return;
        }
        levelOrder(root.left,arr,index*2);
        levelOrder(root.right,arr,index*2+1);

    }
        //遍历数组，计算距离小于distance的叶子节点对数
    public int countPairs(List<Integer> arr, int distance) {
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i+1; j <  arr.size(); j++) {
                if(getDistance(arr.get(i),arr.get(j)) <= distance)
                    count++;

            }

        }
        return count;

    }

    public int getDistance(int x,int y){
        int count=0;
        while (x!= y) {
            if (x > y)
                x /= 2;
            else
                y /= 2;
            count++;
        }
        return count;
    }

    public int countPairs(TreeNode root, int distance) {
            List<Integer> arr = new ArrayList<>();
            levelOrder(root,arr,1);
            return countPairs(arr, distance);
    }

    @Test
    public void test() {
//        TreeNode root = new TreeNode(1);
//        TreeNode node1 = new TreeNode(2);
//        root.left = node1;
//        TreeNode node2 = new TreeNode(3);
//        root.right = node2;
//        TreeNode node3 = new TreeNode(4);
//        node1.left = node3;
//        TreeNode node4 = new TreeNode(5);
//        node1.right = node4;
//        TreeNode node5 = new TreeNode(6);
//        node2.left = node5;
//        TreeNode node6 = new TreeNode(7);
//        node2.right = node6;
        TreeNode root = getRoot();
        System.out.println(countPairs(root, 5));
    }


    public TreeNode getRoot() {
        //生成树 [15,66,55,97,60,12,56,null,54,null,49,null,9,null,null,null,null,null,90]
        TreeNode root = new TreeNode(15);
        TreeNode node1 = new TreeNode(66);
        root.left = node1;
        TreeNode node2 = new TreeNode(55);
        root.right = node2;
        TreeNode node3 = new TreeNode(97);
        node1.left = node3;
        TreeNode node4 = new TreeNode(60);
        node1.right = node4;
        TreeNode node5 = new TreeNode(12);
        node2.left = node5;
        TreeNode node6 = new TreeNode(56);
        node2.right = node6;
        TreeNode node7 = new TreeNode(54);
        node3.right = node7;
        TreeNode node8 = new TreeNode(49);
        node4.right = node8;
        TreeNode node9 = new TreeNode(9);
        node5.right = node9;
        TreeNode node10 = new TreeNode(90);
        node8.right = node10;
        return root;
    }

}
