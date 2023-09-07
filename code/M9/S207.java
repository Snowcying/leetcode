package code.M9;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    boolean flag = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int end = prerequisites[i][1];
            Set<Integer> val = map.get(from);
            if (val == null) {
                val = new HashSet<>();
                map.put(from, val);
            }
            val.add(end);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(map, visited, i);
                if (!flag) {
                    return false;
                }
                visited[i] = -1;
            }

        }
        return flag;
    }

    void dfs(HashMap<Integer, Set<Integer>> map, int[] visited, int i) {
        if (!flag) {
            return;
        }
        if (visited[i] == 1) {
            flag = false;
        } else if (visited[i] == -1) {
        } else {
            visited[i] = 1;
            Set<Integer> val = map.get(i);
            if (val == null) {

            } else {
                for (Integer node : val) {
                    dfs(map, visited, node);
                }
            }

//            for (int j = 0; j < pre.length; j++) {
//                if (pre[j][0] == i) {
//                    int next = pre[j][1];
//                    dfs(pre, visited, next);
//                }
//            }
            visited[i] = -1;
        }
    }

    public static void main(String[] args) {
        int num = 7;
//        int[][] input = {{0, 1}};
        int[][] input = {{1, 0}, {1, 2}, {0, 2}, {0, 5}, {0, 4}, {5, 3}, {5, 6}, {5, 4}};

        System.out.println(new Solution().canFinish(num, input));
    }
}

//
//public class S207 {
//
//    static class Solution {
//        static boolean flag=true;
//        public boolean canFinish(int numCourses, int[][] prerequisites) {
//            if(prerequisites.length==0){
//                return flag;
//            }
//            int[] visited=new int[numCourses];
//            for(int i=0;i<numCourses;i++){
//                dfs(prerequisites,visited,i);
//                if(!flag){
//                    return false;
//                }
//                visited[i]=-1;
//            }
//            return flag;
//        }
//        static void dfs(int[][] pre,int[] visited,int i){
//            if(!flag){
//                return;
//            }
//            if(visited[i]==1){
//                flag= false;
//            }else if(visited[i]==-1){
//            }else {
//                visited[i]=1;
//                for(int j=0;j<pre.length;j++){
//                    if(pre[j][0]==i){
//                        int next=pre[j][1];
//                        dfs(pre,visited,next);
//                    }
//                }
//                visited[i]=0;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int num=2;
////        int[][] input ={{0,1},{1,2},{2,3},{3,0},{4,0},{0,6}};
////        int[][] input ={{0,1},{0,3},{1,3},{1,2},{3,4},{2,4}};
////        int[][] input ={{1,0},{1,2},{0,2},{0,5},{0,4},{5,3},{5,6},{5,4}};
////        int[][] input ={{1,0},{0,1}};
//        int[][] input ={{0,1}};
//        boolean res = new Solution().canFinish(num,input);
//        System.out.println(res);
//    }
//}
