package leet100_199;

import org.junit.Test;

import java.util.*;

/**
 * https://leetcode.cn/problems/sort-list/?envType=study-plan-v2&envId=top-100-liked
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

public class leet148 {
    @Test
    public void test() {
        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(3);
        set.add(7);
        set.add(2);
        set.add(5);
        System.out.println(set);
    }

    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        int n = 0;
        ListNode p = head;
        Set<Integer> set = new TreeSet<>();
        Map<Integer, List<ListNode>> map = new HashMap<>();
        while (p != null) {
            n++;
            set.add(p.val);
            List<ListNode> list = map.getOrDefault(p.val, new ArrayList<ListNode>());
            list.add(p);
            map.put(p.val, list);
            p = p.next;
        }
        p = new ListNode();
        p.next=null;
        ListNode q = p;
        for (Integer integer : set) {
            List<ListNode> listNodes = map.get(integer);
            for (ListNode listNode : listNodes) {
                q.next = listNode;
                q = q.next;
            }
            q.next = null;
        }
        return p.next;
    }
}
