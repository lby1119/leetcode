package leet500_599;

import java.util.Random;

/**
 *
 */

public class leet528 {
}

class Solution {

    int[] pre;
    int total;

    public Solution(int[] w) {
        int n= w.length;
        pre=new int[n];
        pre[0]=w[0];
        total=w[0];
        for (int i = 1; i < n; i++) {
            pre[i]=pre[i-1]+w[i];
            total+=w[i];
        }
    }

    public int pickIndex() {
        int ran= (int) (Math.random()*total)+1;
        int left=0,right=pre.length-1;
        while(left<right){
            int mid=(right-left)/2+left;
            if(pre[mid]<ran){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return left;
    }
}