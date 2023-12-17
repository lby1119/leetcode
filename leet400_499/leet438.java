package leet400_499;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked
 */

public class leet438 {
    @Test
    public void test(){
        String s="cbaebabacd";
        String p="abc";
        findAnagrams(s,p);
    }

    @Test
    public void teststr(){
        String s1="{\"access_token\":\"z7hJznRbwOao_KIi8kd4ZLobjqs4rxjo7U9l46lcH3kC5UFcp-DJyGtzcEvKpPU5_nLuXNkTwRQmuJtleMvtTKZfgg5hVdlIhDHkM5ke3F2hY5FTsA2e1ss7fNP3P2909jQQrTrBlmeMQBCqtm-LXFt-8uEpJvs4nhMi5DaflbTk8qic_bamQeP7WcIIaRdK0yLxWt3lwbwgzodjhCR4l3ClnthsxoGmLx_k0R9K5iWpgNgZCshiiXofSxJi6eRrY1VnAM1ocKIg218mRN_PmV21ZaVm9-0Ui4yfDju-dhJ2CFPD1ZcvOAIpXMW8qU3Z-nIs03Z4WvGXQkrWt8GgXfK8Jej1ANqjeeDHH7uR_qOpvIWSBNFjCjL7muysvnz7Q8aTWs89Z15VkAJeBxjBRf19MEkP086LoyoIca0DHQmw07iQ8FjfQ-bElCnelNeFjgMgorFy40lPfQB4Uj-QZUA7logMR4_7LG1mvlFbJn6R5pPWo7ap0Gt7Rd-tXz8pbOQ1k_Y37zOVnoFPH701k66te72s6-mrpCWLmEuxgr7QTZyFSAoepznGo09Xe_droF6J1dtT8_W6dJNVUaTS0F1YlrXe4WFwPKserYA5yDwLNcbd9-OJf8nY00ogTnXfRlHk-2CBwLU14IR-t4fH9h4xJVWVFeNLLmtAunTd6oASE-VZ0-3DB3dAai6wdUEuVTdRz94BSS8uKCER-VVFpMbssgJ_pF4MGheC9HgSbnuJmEQvYSjkGcZ8FUZ809YRT-zZKZ8TNS_rDcgNNWK-i86TRzDBXKlHq28hL4Inu8XwNr2RhQmzX29nUl0hDL5PnlQDrL4AL00E6lYtYBp9XP_LN5FjYM6v-mr7HcqnI_qewAena7vnXYUG4eVs54qcdOfn3LEX312X_5TYddeIITY39x7ZrkBOum_51bFyLac\",\"token_type\":\"bearer\",\"expires_in\":1209599,\"wechat_access_token\":\"72_ugNZB2RvzlrBBzeMS74zKO_8LnNpmRlaK35iS2vJfLHqt_bbIpeKGHUnz8yIofMt7PO1Ri8-X1WPO70WiZkkbQNUm_E577YzvtLO0phE6fw\",\"wechat_expires_in\":\"7200\",\"wechat_refresh_token\":\"72_pObJ1BehAoPpdR5OBW_blU61Ga8g4j8ByT7z65kcFqGhDC9mOrVrRNo5J1eoBU_SmZQg1TbmHOdZUDL7r5TyV-_wpirGJHjBQpShbHEcRb8\",\"wechat_openid\":\"ouPnP5zJYI0EC2eJ1cZ5tzcwJ3Sc\",\"wechat_scope\":\"snsapi_userinfo\",\"wechat_unionid\":\"oDQwkwzi-ok8149oBXR8TFuGmZnM\",\"wechat_end_time\":\"1694863201345\",\"wechat_errcode\":\"0\",\".issued\":\"Sat, 16 Sep 2023 09:20:01 GMT\",\".expires\":\"Sat, 30 Sep 2023 09:20:01 GMT\"}";


    }


    public List<Integer> findAnagrams(String s, String p) {
        int[] snum=new int[26];
        int[] pnum=new int[26];
        List<Integer> list=new ArrayList<>();

        if(s.length()<p.length())
            return list;

        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();

        for (int i = 0; i < p.length(); i++) {
            snum[sCharArray[i]-'a']++;
            pnum[pCharArray[i]-'a']++;
        }
        if(s.length()==p.length()){
            if(Arrays.equals(pnum,snum)){
                list.add(0);
                return list;
            }else {
                return list;
            }
        }

        if(Arrays.equals(pnum,snum)) list.add(0);
        int i=0;
        while (i<s.length()-p.length()){
            i++;
            snum[sCharArray[i-1]-'a']--;
            snum[sCharArray[i+p.length()-1]-'a']++;
            if(Arrays.equals(snum,pnum)){
                list.add(i);
            }
        }
        return list;
    }
}
