package leet700_799;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *https://leetcode.cn/problems/shortest-completing-word/
 * 748. 最短补全词
 */

public class leet748 {

    @Test
    public void test(){

        String s="1s3 PSt";
               String[] w= {"step","steps","stripe","stepple"};
        System.out.println(shortestCompletingWord(s,w));
    }
    public String shortestCompletingWord(String licensePlate, String[] words) {

        String license=licensePlate.toLowerCase();
        Map<Character, Integer> lecenseNum = getNum(license);
        int[] nums=new int[words.length];
        int count;

        for (int i = 0; i < words.length; i++) {
            count=0;
            Map<Character, Integer> wordNum = getNum(words[i]);
            for(Character key:lecenseNum.keySet()){
                if(wordNum.getOrDefault(key,0)-lecenseNum.getOrDefault(key,0)<0){
                    count=-1;
                    break;
                }

            }
            if(count==-1)
                nums[i]=count;
            else nums[i]=words[i].length();
        }


        int min=Integer.MAX_VALUE;
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=-1&&min>nums[i]){
                min=nums[i];
                k=i;
            }
        }
        return words[k];

    }

    public Map<Character,Integer> getNum(String s){
        char[] charArray = s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();

        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i]-'a'>=0&&charArray[i]-'a'<=25){
                map.put(charArray[i],map.getOrDefault(charArray[i],0)+1);
            }
        }
        return map;

    }
}
