package leet200_299;

/**
 *
 */

public class leet283 {
    public void moveZeroes(int[] nums) {
        if(nums.length<2)
            return;

        int i=0,j=1;
        while(i< nums.length){
            if(nums[i]==0){
                j=Math.max(j,i+1);
                while(j< nums.length&&nums[j]==0) j++;
                if(j== nums.length) break;

                nums[i]=nums[j];
                nums[j]=0;
            }else {
                i++;
            }
        }

    }
}
