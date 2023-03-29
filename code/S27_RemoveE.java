package code;

public class S27_RemoveE {
    public static int removeElement(int[] nums, int val) {
        int l = 0;
        for (int q = 0; q < nums.length; q++) {
            nums[l] = nums[q];
            if (nums[q] != val) {
                l++;
            }
        }
        return l;
    }

    public static void removeElement283(int[] nums) {
        int l = 0;
        for (int q = 0; q < nums.length; q++) {
            nums[l] = nums[q];
            if (nums[q] != 0) {
                l++;
            }
        }
        for (int i = l; i < nums.length; i++) {
            nums[i] = 0;
        }
//        return l;
    }

    public static boolean compare844(String s, String t) {
        int l1 = 0;
        int l2 = 0;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        for (int q = 0; q < s1.length; q++) {
            if (s1[q] == '#') {
                l1=Math.max(l1-1,0);
            } else {
                s1[l1] = s1[q];
                l1++;
            }
        }
        for (int q = 0; q < t1.length; q++) {
            if (t1[q] == '#') {
                l2=Math.max(l2-1,0);
            } else {
                t1[l2] = t1[q];
                l2++;
            }
        }
        for (int i = 0; i < l1; i++) {
            System.out.println(s1[i]);
            System.out.println(t1[i]);
        }
        if(l1!=l2){
            return false;
        }else {
            for(int i=0;i<l1;i++){
                if(s1[i]!=t1[i]){
                    return false;
                }
            }
            return true;
        }

    }

    public static void main(String[] args) {
//        int[] nums={0,1,2,2,3,0,4,2};
//        int val=2;
//        for(int x:nums){
//            System.out.println(x);
//        }
//        System.out.println("----------------");
////        int len=removeElement(nums,val);
//        removeElement283(nums);
//        for(int i=0;i<nums.length;i++){
//            System.out.println(nums[i]);
//        }
        System.out.println(compare844("a##c", "#a#c"));


    }
}
