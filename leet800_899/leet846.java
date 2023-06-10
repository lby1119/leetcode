package leet800_899;


import java.util.Arrays;
import java.util.HashMap;

public class leet846 {
    public static void main(String[] args) {

        int[] h={1,2,3,6,2,3,4,7,8};
        int g=3;
        boolean b=new leet846().isNStraightHand(h,g);
        System.out.println(b);
    }
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)
            return false;
        Arrays.sort(hand);

        HashMap<Integer,Integer> has=new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            if(has.containsKey(hand[i])){
                has.put(hand[i],has.get(hand[i])+1);
            }else {
                has.put(hand[i],1);
            }
        }


        int num=0;
        for(int i=0;i<hand.length;i++){
           if (has.containsKey(hand[i])){
               num=has.get(hand[i]);
               for (int j = hand[i]; j < hand[i]+groupSize; j++) {
                   if(has.containsKey(j)&&has.get(j)-num>=0){
                       has.put(j,has.get(j)-num);
                   }else
                       return false;

                   if(has.get(j)==0)
                       has.remove(j);
               }
           }
        }

        return true;
    }
}
