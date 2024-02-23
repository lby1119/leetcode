package leet200_299;


import java.util.ArrayList;

public class leet234 {
    public boolean isPalindrome(ListNode head) {
        int n=0;
        ListNode p=head;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (p!=null){
            arrayList.add(p.val);
            p=p.next;
            n++;
        }
        for (int i=0;i<n/2;i++){
            if(arrayList.get(i)!=arrayList.get(n-i-1))
                return false;
        }
        return true;
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

