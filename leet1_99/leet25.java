package leet1_99;

/**
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-100-liked
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class leet25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode pro = new ListNode();
        pro.next = head;

        ListNode former = pro;
        while (former != null) {
            ListNode last = former;
            int i = 0;
            while (last != null && i <= k) {
                last = last.next;
                i++;
            }
            if (i < k + 1) return pro.next;
            ListNode temp = new ListNode();
            temp.next = null;
            ListNode p = former.next;
            ListNode pLast = former.next;

            i = 0;
            while (i < k) {
                ListNode q = p;
                p = p.next;
                q.next = temp.next;
                temp.next = q;
                i++;
            }
            former.next = temp.next;
            pLast.next = last;
            former = pLast;
        }
        return pro.next;
    }
}
