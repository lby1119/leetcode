package leet300_399;

import org.junit.Test;

import java.util.*;

/**
 *
 */

public class leet373 {

    @Test
    public void test() {
//        int[] nums1 = {1, 7, 11}, nums2 = {2, 4, 6};
//        int k = 3;
        int[] nums1 = {1,2,4,5,6}, nums2 = {3,5,7,9};
        int k = 20;
        System.out.println(kSmallestPairs(nums1,nums2,k));
    }

    Map<Integer, Queue<List<Integer>>> map = new HashMap<>();
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);

        int n = nums1.length;
        int m = nums2.length;
        int[][] bo = new int[n][m];
        List<Integer> list = new ArrayList<>();

        set(nums1, nums2, 0, 0,queue);
        bo[0][0] = 1;


        while (lists.size() < k) {
            Integer poll = queue.poll();
            Queue<List<Integer>> lists1 = map.get(poll);
            list = lists1.poll();

            ArrayList<Integer> objects = new ArrayList<>();
            objects.add(nums1[list.get(0)]);
            objects.add(nums2[list.get(1)]);
            lists.add(objects);


            if (list.get(0) + 1 < n && bo[list.get(0) + 1][list.get(1)] == 0) {
                set(nums1, nums2, list.get(0) + 1, list.get(1),queue);
                bo[list.get(0) + 1][list.get(1)] =1;
            }
            if (list.get(1) + 1 < m && bo[list.get(0) ][list.get(1)+1] == 0) {
                set(nums1, nums2, list.get(0), list.get(1) + 1,queue);
                bo[list.get(0) ][list.get(1)+1]=1;
            }
        }
        return lists;

    }

    public void set(int[] nums1, int[] nums2, int i, int j,PriorityQueue<Integer> queue) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        Queue<List<Integer>> put = map.getOrDefault(nums1[i] + nums2[j], new LinkedList<>());
        put.add(list);
        map.put(nums1[i] + nums2[j], put);
        queue.add(nums1[i] + nums2[j]);
    }

}
