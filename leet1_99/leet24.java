//package leet1_99;
//
///**
// *https://leetcode.cn/problems/swap-nodes-in-pairs/description/?envType=study-plan-v2&envId=top-100-liked
// */
// class ListNode {
//      int val;
//      ListNode next;
//     ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }
//
//public class leet24 {
//    public ListNode swapPairs(ListNode head) {
//        if(head==null) return null;
//        ListNode pro=new ListNode();
//        pro.next=head;
//
//        ListNode former=pro;
//        while (former!=null&&former.next!=null&&former.next.next!=null){
//            ListNode p=former.next;
//            ListNode q=former.next.next;
//            p.next=q.next;
//            q.next=p;
//            pro.next=q;
//
//            former=former.next.next;
//        }
//        return pro.next;
//
//    }
//}
