package leet2000_2099;

/**
 *
 */

public class leet2011 {
    public int finalValueAfterOperations(String[] operations) {
        int sum=0;
        for(String s:operations){
            if(s.charAt(1)=='+') sum++;
            else sum--;
        }
        return sum;
    }
}
