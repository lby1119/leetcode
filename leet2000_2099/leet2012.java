package leet2000_2099;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *https://leetcode.cn/problems/sum-of-beauty-in-the-array/
 */

public class leet2012 {
    public int sumOfBeauties(int[] nums) {
        int sum=0;
        int n=nums.length;

        for (int i = 1; i < n-2; i++) {

        }



        return sum;
    }


    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("a"+i);
        }
        String todayFailedSmsDetail = String.join("\n", list);
        System.out.println(todayFailedSmsDetail);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.minusHours(-1);
        System.out.println(localDateTime);

    }


}
