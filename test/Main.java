package test;


import java.util.Scanner;

/**
 *
 */

public class Main {

    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int n=Integer.parseInt(input.nextLine());
        String str= input.nextLine();
        char[] charArray = str.toCharArray();

        if(n==1)
            { System.out.println(1);
                return;
            }

        if(n==2){
            if(charArray[0]==charArray[1]){
                System.out.println(2);
            }else {
                System.out.println(1);
            }
            return;
        }

        int[][] dp=new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i]=1;
        }

        int maxNum=0;
        for (int length = 2; length <=n ; length++) {
            for(int i=0;i<n;i++){
                int j=i+length-1;

                if(j>=n) break;
                if(charArray[i]==charArray[j]){
                    if(j-i<3){
                        dp[i][j]=1;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                    maxNum=Math.max(maxNum,j-i+1);
                }
            }
        }

        System.out.println(maxNum);
    }


}
