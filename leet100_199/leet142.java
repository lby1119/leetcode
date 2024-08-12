//package leet100_199;
//
///**
// *https://leetcode.cn/problems/linked-list-cycle-ii/description/?envType=study-plan-v2&envId=top-100-liked
// */
//  class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) {
//          val = x;
//          next = null;
//      }
//  }
//public class leet142 {
//    public ListNode detectCycle(ListNode head) {
//        ListNode p=head;
//        ListNode q=head;
//        while(true) {
//            if(q==null||q.next==null) return null;
//            p=p.next;
//            q=q.next.next;
//            if(p==q) break;
//        }
//        q=head;
//        while (p!=null){
//            if(p==q) return p;
//            p=p.next;
//            q=q.next;
//        }
//        return null;
//    }
//}
