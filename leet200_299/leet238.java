package leet200_299;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&envId=top-100-liked
 */

public class leet238 {
    @Test
    public void test() {
        int[] nums = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] products = new int[n];
        products[0] = 1;
        for (int i = 1; i < n; i++) {
            products[i] = products[i - 1] * nums[i - 1];
        }
        int r = 1;
        for (int i = n - 1; i >=0; i--) {
            products[i] = products[i] * r;
            r = r * nums[i];
        }

        return products;
    }
}
