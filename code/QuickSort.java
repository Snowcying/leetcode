package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuickSort {

    static int partSort(int[] nums, int l, int r) {
        int preL = l;
        int x = nums[l];
        while (l < r) {
            while (nums[r] >= x && l < r) {
                r--;
            }
            while (nums[l] <= x && l < r) {
                l++;
            }
            swap(nums, r, l);
        }
        swap(nums, l, preL);
        return l;

    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void qSort(int[] nums, int l, int r) {

        if (l >= r) {
            return;
        }
        int key = partSort(nums, l, r);
        qSort(nums, l, key - 1);
        qSort(nums, key + 1, r);

    }

    static void maopaoSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    static List<Integer> sort(int[] nums) {
        qSort(nums, 0, nums.length - 1);
//        maopaoSort(nums);
        List<Integer> ans = new ArrayList<>();
//        ans= Arrays.asList(nums);
        for (int x : nums) {
//            System.out.println(x);
            ans.add(x);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 8, 6, 5};
//        int[] nums = {3, 18, 6, 13, 5, 16, 10, 19, 1, 15};
        System.out.println(sort(nums));
    }
}

class HeapSort {
    int[] a;
    int max;
    int count;

    public HeapSort(int capacity) {
        a = new int[capacity];
        max = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count >= max) return;
        count++;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i / 2] > a[i]) {
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    public void removeTop() {
        if (count == 0) return;
        a[1] = a[count];
        count--;
        adjustHeap();
    }

    public void adjustHeap() {
        int i = 1;
        while (true) {
            int j = i;
            if (i * 2 <= max && a[i * 2] < a[i]) j = i * 2;
            if (i * 2 + 1 <= max && a[i * 2 + 1] < a[i * 2]) j = i * 2 + 1;
            if (j == i) break;
            swap(a, i, j);
            i = j;
        }
    }

    public void printHeap() {
        for (int i = 1; i <= count; i++) {
            System.out.println(a[i]);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort(100);
        Random random = new Random(111);
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(100);
            heapSort.insert(num);
        }
        heapSort.printHeap();
        System.out.println("_______________");
        heapSort.removeTop();
        heapSort.printHeap();
    }

}

class divideSort {

    static void merge(int[] nums,int left,int mid,int right){
        int s1=left,s2=mid+1;
        int[] temp=new int[right-left+1];
        int i=0;
        while(s1<=mid&&s2<=right){
            temp[i++]=nums[s1]<nums[s2]?nums[s1++]:nums[s2++];
        }
        while(s1<=mid){
            temp[i++]=nums[s1++];
        }
        while(s2<=right) temp[i++]=nums[s2++];
        for(int j=0;j<temp.length;j++){
            nums[left+j]=temp[j];
        }
    }

    static void mergeSort(int[] nums,int left,int right){
        if(left>=right) return;
        int mid=(left+right)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 8, 6, 5};
        mergeSort(nums,0,nums.length-1);
        for(int x:nums) System.out.println(x);
    }
}
