package leet100_199;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */

//class Node {
//    public int val;
//    public Node left;
//    public Node right;
//    public Node next;
//
//    public Node() {}
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, Node _left, Node _right, Node _next) {
//        val = _val;
//        left = _left;
//        right = _right;
//        next = _next;
//    }
//};

//public class leet117 {
//
//    @Test
//    public void test(){
//        Node root=new Node(1);
//        connect(root);
//    }
//
//    public Node connect(Node root) {
//        if(root==null)
//            return root;
//
//
//        Queue<Node> queue=new LinkedList<>();
//        int nowNumber=1;
//        int nextNumber=0;
//        queue.add(root);
//
//        while(queue.size()>0){
//            while(nowNumber>0){
//                Node node=queue.remove();
//                nowNumber--;
//                if(nowNumber==0){
//                    node.next=null;
//                }else {
//                    node.next=queue.peek();
//                }
//
//                if(node.left!=null) {queue.add(node.left); nextNumber++;}
//                if(node.right!=null) {queue.add(node.right);nextNumber++;}
//            }
//           nowNumber=nextNumber;
//            nextNumber=0;
//        }
//        return root;
//    }
//}
