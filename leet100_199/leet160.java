package leet100_199;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/?envType=study-plan-v2&envId=top-100-liked
 */

public class leet160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        int n = 0, m = 0;
        while (p != null) {
            p = p.next;
            n++;
        }
        while (q != null) {
            q = q.next;
            m++;
        }
        p = headA;
        q = headB;
        if (m > n) {
            for (int i = 0; i < m - n; i++) q = q.next;
        } else {
            for (int i = 0; i < n - m; i++) p = p.next;
        }

        while (p != null && q != null) {
            if (p == q) return p;
            p = p.next;
            q = q.next;

        }
        return null;

    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
