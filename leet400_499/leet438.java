package leet400_499;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked
 */

public class leet438 {
    @Test
    public void test(){
        String s="cbaebabacd";
        String p="abc";
        findAnagrams(s,p);
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] snum=new int[26];
        int[] pnum=new int[26];
        List<Integer> list=new ArrayList<>();

        if(s.length()<p.length())
            return list;

        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();

        for (int i = 0; i < p.length(); i++) {
            snum[sCharArray[i]-'a']++;
            pnum[pCharArray[i]-'a']++;
        }
        if(s.length()==p.length()){
            if(Arrays.equals(pnum,snum)){
                list.add(0);
                return list;
            }else {
                return list;
            }
        }

        if(Arrays.equals(pnum,snum)) list.add(0);
        int i=0;
        while (i<s.length()-p.length()){
            i++;
            snum[sCharArray[i-1]-'a']--;
            snum[sCharArray[i+p.length()-1]-'a']++;
            if(Arrays.equals(snum,pnum)){
                list.add(i);
            }
        }
        return list;
    }
}
