package leet200_299;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked
 */

public class leet239 {
    @Test
    public void test(){
        int[] nums={1,3,-1,-3,5,3,6,7};
        int k=3;
        maxSlidingWindow(nums,k);
    }


        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            Deque<Integer> deque = new LinkedList<Integer>();
            for (int i = 0; i < k; ++i) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }

            int[] ans = new int[n - k + 1];
            ans[0] = nums[deque.peekFirst()];
            for (int i = k; i < n; ++i) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                while (deque.peekFirst() <= i - k) {
                    deque.pollFirst();
                }
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
            return ans;
        }


}
