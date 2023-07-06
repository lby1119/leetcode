package leet600_699;

import org.junit.Test;

/**
 *https://leetcode.cn/problems/count-binary-substrings/
 * 696. 计数二进制子串
 */

public class leet696 {


    @Test
    public void test(){
        String s="00110011";
        System.out.println(countBinarySubstrings(s));
    }
    public int countBinarySubstrings(String s) {
        char[] charArray = s.toCharArray();
        int count=0;
        int num;
        for (int i = 0; i < charArray.length; i++) {
            num=1;
            int j=i+1;
            while (j<charArray.length&&charArray[i]==charArray[j]){
                num++;
                j++;
            }



            while (j<charArray.length&&charArray[j]!=charArray[i]&&num>0){
                j++;
                num--;
            }
            if(num==0){
                count++;
            }


        }
        return count;
    }
}
