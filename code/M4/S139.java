package code.M4;

import java.util.*;

public class S139 {
    static HashSet<String> set = new HashSet<>();

    static public boolean wordBreak(String s, List<String> wordDict) {
        set.addAll(wordDict);
        boolean[] dp1=new boolean[s.length()+1];
        dp1[0]=true;
        for(int i=1;i<=s.length();i++){
//            for(int j=0;j<i;j++){
            for(int j=i-1;j>=0;j--){
                if(!dp1[j]){
                    continue;
                }
                String sub=s.substring(j,i);
                if(dp1[j]&&wordDict.contains(sub)){
                    dp1[i]=true;
                    break;
                }
            }
        }


        return dp1[s.length()];
    }
    static public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp1=new boolean[s.length()+1];
        dp1[0]=true;
        for(int i=1;i<=s.length();i++){
            for(String s1:wordDict){
                int l=s1.length();
                if(i>=l&&s1.equals(s.substring(i-l,i))){
                    dp1[i]=dp1[i]||dp1[i-l];
                }
            }
        }
        return dp1[s.length()];
    }

    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int target=sc.nextInt();
            int[] nums=new int[100];
            int n;
            n=sc.nextInt();
            for(int i=0;i<n;i++){
                nums[i]=sc.nextInt();
            }
            Map<Integer,Integer> m=new HashMap<Integer,Integer>();
            System.out.println(n);
            for(int i=0;i<n;i++){
                if(m.containsKey(target-nums[i])){
                    System.out.println(i);
                    System.out.println(m.get(target-nums[i]));
                }
                m.put(nums[i],i);
            }
        }


//        m.containsKey()

//创建对象sc//
//        List<String>wordDict=new ArrayList<>(){
//            {
//                add("leet");
//                add("code");
//            }
//        };
//        List<String> wordDict=new ArrayList<>(Arrays.asList("leet", "code"));
//        System.out.println(wordBreak2(s,wordDict));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int a=sc.nextInt();
            System.out.println(a);
            String b=sc.next();
            System.out.println(b);
        }
    }
}
