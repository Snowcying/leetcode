package code;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> s1=new Stack<>();
        Map<Character,Character> m1=new HashMap<Character,Character>(){{
            put(')','(');
            put('}','{');
            put(']','[');
        }};
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(m1.containsKey(current)){
                if(!s1.empty()){
//                    String c2=String.valueOf(s1.pop());
                    Character c2 = s1.pop();
                    if(c2!=m1.get(current)){
                        return false;
                    }
                }
                else {
                    return false;
                }
            }else{
                s1.push(current);
            }
        }
        if(s1.empty()){
            return true;
        }else return false;
    }
}

public class Hot20 {
    public static void main(String[] args) {
//        Stack<String> s1=new Stack<>();
        Solution s1=new Solution();
        System.out.println(s1.isValid("(){}"));
    }
}
