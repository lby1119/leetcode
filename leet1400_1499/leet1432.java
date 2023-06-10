package leet1400_1499;

public class leet1432 {

    public static void main(String[] args) {
        System.out.println(new leet1432().maxDiff(100000000));
    }
    public int maxDiff(int num) {

        int[] nums = new int[8];
        int len = 0;
        while (num != 0) {
            nums[len] = num % 10;
            num = num / 10;
            len++;
        }

        int a_x=nums[len-1],a=0;
        int b_x=-1,b=0;
        for (int i = len-1; i >=0 ; i--) {
            if(nums[i]!=9)
            {
                a_x=nums[i];
                break;
            }
        }


        for(int i = len-1; i >=0 ; i--){
            if(nums[i]==a_x){
                a=a*10+9;
            }else {
                a=a*10+nums[i];
            }
        }


        if(nums[len-1]==1){
            for (int i = len-2; i >=0 ; i--) {
                if(nums[i]!=0&&nums[i]!=1)
                {
                    b_x=nums[i];
                    break;
                }
            }
            for(int i = len-1; i >=0 ; i--){
                if(nums[i]==b_x){
                    b=b*10+0;
                }else {
                    b=b*10+nums[i];
                }
            }

        }else{
            b_x=nums[len-1];
            for(int i = len-1; i >=0 ; i--){
                if(nums[i]==b_x){
                    b=b*10+1;
                }else {
                    b=b*10+nums[i];
                }
            }

        }
        return a-b;
    }
}
