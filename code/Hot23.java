package code;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution23 {
    public ListNode merge2Lists(ListNode l1,ListNode l2){
        ListNode preHead = new ListNode();
        ListNode tail = new ListNode();
        preHead.next=tail;
        while(l1!=null&&l2!=null){
            int v1=l1.val,v2=l2.val;
            ListNode t=new ListNode();
            if(v1<v2){
                t.val=v1;
                l1=l1.next;
            }else{
                t.val=v2;
                l2=l2.next;
            }
            tail.next=t;
            tail=t;
        }
        if(l1!=null){
            tail.next=l1;
        }
        if(l2!=null){
            tail.next=l2;
        }
        return preHead.next.next;
    }

    public ListNode merge(ListNode[] lists,int l,int r){
        if(l==r) {
            return lists[l];
        } else if (l>r) {
            return null;
        }
        int mid=(l+r)/2;
       return merge2Lists(merge(lists,l,mid),merge(lists,mid+1,r));
    }

    public ListNode mergeKLists(ListNode[] lists) {

        return merge(lists,0,lists.length-1);
//        if(lists.length==0){
//            return null;
//        }
//        ListNode start = lists[0];
//        for(int i=1;i<lists.length;i++){
//            start=merge2Lists(start,lists[i]);
//        }
//        return start;
    }
}

public class Hot23 {
    public static void main(String[] args) {
//        LinkList LL = new LinkList();

        ListNode[] lists = new ListNode[10];
        int[][] input = {{-11,1, 4, 5}, {1, 3, 4}, {2, 6},{1,2,3}};
        for (int x = 0; x < input.length; x++) {
            lists[x] = LinkList.initLinkByArray(input[x]);
        }
//        LL.printAll(lists[0]);
//        LL.printAll(lists[1]);
//        LL.printAll(lists[2]);


        Solution23 s23 = new Solution23();
        ListNode ans = s23.mergeKLists(lists);
        LinkList.printAll(ans);
//        LL.printAll(s23.merge2Lists(lists[0],lists[1]));

    }
}
