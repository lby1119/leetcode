package leet300_399;

import org.junit.Test;

import java.util.SplittableRandom;

/**
 *反转字符串元音字母 a e i o u
 */

public class leet345 {

    @Test
    public void test(){
//        String s="leetcode";
        String s=".,";
        System.out.println(reverseVowels(s));
    }


    public String reverseVowels(String s) {
        if(s.length()==1) return s;
        char[] charArray = s.toCharArray();
        String vowel="aeiouAEIOU";
        int n=charArray.length;



        int i=0,j=n-1;
        while(i<j){
            while(!vowel.contains(""+charArray[i])&&i<j) i++;
            while(!vowel.contains(""+charArray[j])&&i<j) j--;
            if(i<j){
            char temp=charArray[i];
            charArray[i]=charArray[j];
            charArray[j]=temp;
            i++;
            j--;}
        }
        return  new String(charArray);
    }
}
