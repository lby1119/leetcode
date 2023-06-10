package leet400_499;

public class leetcode409 {
    public  int longestPalindrome(String s) {
        int n=s.length();
        int[] num=new int[52];
        for(int i=0;i<52;i++)
            num[i]=0;

        char[] chars = s.toCharArray();
        for(int i=0;i<n;i++){
            if(chars[i]>96){
                num[chars[i]-'A'-6]++;
            }else{
                num[chars[i]-'A']++;
            }

        }

        int count=0;
        boolean first=false;
        for(int i=0;i<52;i++){
            if(num[i]%2==0)
            {
                count+=num[i];
            }else{
                count+=num[i]-1;
                if(first==false){
                    count++;
                    first=true;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s="zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez";
        leetcode409 test=new leetcode409();
        int n=test.longestPalindrome(s);
        System.out.println(n);
    }

}
