package leet1_99;

import java.util.HashMap;

public class leet16 {
    public static void main(String[] args) {
        Solution sol=new Solution();
        int[] a=sol.masterMind("RGBY","GGRR");
        System.out.println(a[0]+" "+a[1]);
//        HashMap<Character, Integer> countSol=new HashMap<Character, Integer>();
//        System.out.println(countSol.get('k'));

    }
}

class Solution {
    public int[] masterMind(String solution, String guess) {
        int[] nums={0,0};
        char[] sol = solution.toCharArray();
        char[] gus = guess.toCharArray();

        for(int i=0;i<4;i++){
            if(sol[i]==gus[i]){
                nums[0]++;
            }
        }

        HashMap<Character, Integer> countSol=new HashMap<Character, Integer>();
        HashMap<Character, Integer> countGus=new HashMap<Character, Integer>();

        for(int i=0;i<4;i++){
            if(countSol.containsKey(sol[i])){
                countSol.replace(sol[i],countSol.get(sol[i])+1);
            }else{
                countSol.put(sol[i],1);
            }

            if(countGus.containsKey(gus[i])){
                countGus.replace(gus[i],countGus.get(gus[i])+1);
            }else{
                countGus.put(gus[i],1);
            }
        }

        int count=0;
        for(char c : countSol.keySet()){
            if(countGus.containsKey(c)){
                count+=countSol.get(c)<countGus.get(c) ? countSol.get(c):countGus.get(c);
            }
        }



        nums[1]=count-nums[0];




        return nums;

    }
}