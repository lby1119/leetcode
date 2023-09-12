package leet_hot_100;

import org.junit.Test;

import java.util.*;

/**
 *
 */

public class leet49 {

    @Test
    public void test(){
        String[] strings={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strings));

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String string = String.valueOf(charArray);

            if(map.containsKey(string)){
                List<String> strings = map.get(string);
                strings.add(strs[i]);
                map.put(string,strings);
            }else {
                List<String> strings=new ArrayList<>();
                strings.add(strs[i]);
                map.put(string,strings);
            }
        }

        List<List<String>> lists=new ArrayList<>();
        for (List<String> list:map.values()){
            lists.add(list);
        }
        return lists;

    }
}
