package leet1800_1899;

/**
 *https://leetcode.cn/problems/maximum-distance-between-a-pair-of-values/
 * 1855. 下标对中的最大距离
 */

public class leet1855 {

    public int maxDistance(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;

        int i=0,maxD=0;

        for (int j=0; j < n2 ; j++) {
            while (i<n1&&nums1[i]>nums2[j]) i++;

            if(i<n1){
                maxD=Math.max(maxD,j-i);
            }

            if(j<i) j=i-1;
        }

        return maxD;
    }
}
