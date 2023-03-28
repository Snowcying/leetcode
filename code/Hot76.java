package code;

public class Hot76 {
    class Solution {
        public static String minWindow(String s, String t) {
            int[] need=new int[128];
            for(int i=0;i<t.length();i++){
                need[t.charAt(i)]++;
            }
            int needs=t.length();
            int l=0,r=0,max=Integer.MAX_VALUE,start=-1;
            while(r<s.length()){
                char c=s.charAt(r);
                if(need[c]>0){
                    needs--;
                }
                need[c]--;
                if(needs==0){
                    while(l<r&&need[s.charAt(l)]<0){
                        need[s.charAt(l)]++;
                        l++;
                    }
                    if(r-l+1<max){
                        max=r-l+1;
                        start=l;
                    }
                    need[s.charAt(l)]++;
                    needs++;
                    l++;
                }
                r++;
            }
            return max==Integer.MAX_VALUE?"":s.substring(start,start+max);
        }

    }
    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String p="ABC";
        System.out.println(Solution.minWindow(s,p));
    }
}
