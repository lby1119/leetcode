package leet700_799;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *https://leetcode.cn/problems/rotate-string/
 * 796. 旋转字符串
 */

public class leet796 {

    @Test
    public void test(){

        System.out.println(rotateString("abcde","abced"));
    }


    public boolean rotateString(String s, String goal) {


        char[] sCharArray = s.toCharArray();
        char[] goalCharArray = goal.toCharArray();

        if(sCharArray.length!=goalCharArray.length)
            return false;

        char index=goalCharArray[0];

        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < goalCharArray.length; i++) {
            if(index==sCharArray[i]){
                list.add(i);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            int indexS=list.get(i);
            int indexG=0;
            while (indexG<goalCharArray.length)
            {
                if(indexS==goalCharArray.length)
                    indexS=0;

                if(sCharArray[indexS]!=goalCharArray[indexG])
                    break;
                indexG++;
                indexS++;
            }

            if(indexG==goalCharArray.length)
                return true;
        }
        return false;
    }
}
