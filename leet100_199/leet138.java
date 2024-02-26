package leet100_199;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class leet138 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node q = head;
        Map<Node, Node> nodeMap = new HashMap<>();
        Node p = new Node(q.val);
        Node headCopy = p;

        nodeMap.put(q, p);
        while (q.next != null) {
            Node temp = new Node(q.next.val);
            nodeMap.put(q.next, temp);
            q = q.next;
            p.next = temp;
            p = p.next;
        }

        p = headCopy;
        q = head;
        while (q != null) {
            Node random = q.random;
            if (random != null) {
                p.random = nodeMap.get(random);
            }
            p = p.next;
            q = q.next;
        }
        return headCopy;
    }
}
