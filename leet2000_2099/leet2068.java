package leet2000_2099;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *https://leetcode.cn/problems/check-whether-two-strings-are-almost-equivalent/
 * 2068. 检查两个字符串是否几乎相等
 */

public class leet2068 {

    @Test
    public void test(){
        String s1="aaaa";
       String s2= "bccb";
       checkAlmostEquivalent(s1,s2);
    }

    public boolean checkAlmostEquivalent(String word1, String word2) {
        Map<Character,Integer> map1=new HashMap<>();
        Map<Character,Integer> map2=new HashMap<>();

        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();

        for (int i = 0; i < charArray1.length; i++) {
            if(map1.containsKey(charArray1[i])){
                map1.put(charArray1[i],map1.get(charArray1[i])+1);
            }else {
                map1.put(charArray1[i],1);
            }
        }

        for (int i = 0; i < charArray2.length; i++) {
            if(map2.containsKey(charArray2[i])){
                map2.put(charArray2[i],map2.get(charArray2[i])+1);
            }else {
                map2.put(charArray2[i],1);
            }
        }

        for (int i = 0; i < 26; i++) {


            int abs = Math.abs( map1.getOrDefault((char)(i + 'a'), 0)- map2.getOrDefault((char)(i + 'a'), 0) );

            if(abs>3)
                return false;
        }

        return true;

    }
}
