//package leet1_99;
//
//
//
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) {
//         val = x;
//         next = null;
//     }
// }
//
//public class leet52 {
//    public static void main(String[] args) {
//
//    }
//
//    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        int headALen = 0;
//        int headBlen = 0;
//        ListNode a = headA, b = headB;
//
//        while (a != null) {
//            headALen++;
//            a = a.next;
//        }
//
//        while (b != null) {
//            headBlen++;
//            b = b.next;
//        }
//        a = headA;
//        b = headB;
//        if (headALen > headBlen) {
//            int num = headALen - headBlen;
//            for (int i = 0; i < num; i++) {
//                a = a.next;
//            }
//
//            while (a != null) {
//                if (a != b) {
//                    a = a.next;
//                    b = b.next;
//                } else return a;
//
//            }
//        } else {
//            int num = headBlen - headALen;
//            for (int i = 0; i < num; i++) {
//                b = b.next;
//            }
//
//            while (b != null) {
//                if (a != b) {
//                    a = a.next;
//                    b = b.next;
//                } else return b;
//            }
//        }
//
//        return null;
//    }
//
//    ListNode get(ListNode headA,int numA, ListNode headB,int numB){
//        int num=numA-numB;
//        for (int i = 0; i < num; i++) {
//            headA=headA.next;
//        }
//
//        while(headA!=null){
//            if(headA!=headB){
//                headA=headA.next;
//                headB=headB.next;
//            }
//            else return headA;
//
//        }
//
//        return null;
//    }
//}
