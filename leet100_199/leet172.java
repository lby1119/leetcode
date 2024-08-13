package leet100_199;

import org.junit.Test;

/**
 *
 */

public class leet172 {
    @Test
    public void test(){
        System.out.println(trailingZeroes(30));
    }
    public int trailingZeroes(int n) {
        int count = n/5;
        int zeroNum = 0;
        for(int i=0;i<=count;i++){
            int num = i*5;
            if(num%5==0){
                while (num%5==0 && num !=0){
                    zeroNum++;
                    num /= 5;
                }
            }else {
                zeroNum++;
            }
        }
        return zeroNum;
    }
}
