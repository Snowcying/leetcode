package code;

class Solution4 {

    static public int findK(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k) {
//        int target=k;
        int len1 = e1 - s1 + 1;
        int len2 = e2 - s2 + 1;
        if (len1 > len2) return findK(nums2, s2, e2, nums1, s1, e1, k);
        if (len1 == 0) return nums2[s2 + k - 1];
        if (k == 1) return Math.min(nums1[s1], nums2[s2]);

        int i = s1 + Math.min(len1, k / 2) - 1;
        int j = s2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            return findK(nums1, s1, e1, nums2, j + 1, e2, k - (j - s2 + 1));
        }
        {
            return findK(nums1, i + 1, e1, nums2, s2, e2, k - (i - s1 + 1));
        }

    }

    static public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        return (findK(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left) + findK(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right)) * 0.5;
    }
}

public class Hot4 {
    public static void main(String[] args) {
//        int[] num1={1,2,3,4};
//        int[] num1 = {1, 3, 4, 7, 9};
//        int[] num2={2,3,3,3,7,9,10};
//        int[] num2 = {2, 4, 6, 8, 10, 12, 14};
        int[] num1={1,2};
        int[] num2={3,4};
        System.out.println(Solution4.findMedianSortedArrays(num1, num2));
    }
}
