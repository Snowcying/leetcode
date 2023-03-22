package code;

import java.util.*;

class Solution49 {
    static public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<String,List<String>>();
        for(String str:strs){
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String key=new String(chars);
            if(map.get(key)==null){
                List<String> list=new ArrayList<>();
                map.put(key,list);
            }
            List<String> list1 = map.get(key);
            list1.add(str);
        }
        List<List<String>>ans=new ArrayList<>();
        for(List<String>l1:map.values()){
            ans.add(l1);
        }
        return ans;
    }
}
public class Hot49 {
    public static void main(String[] args) {
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(Solution49.groupAnagrams(strs));
    }
}
