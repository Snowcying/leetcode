package code;


import java.util.Arrays;
import java.util.List;

class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(0);
        ListNode tail=new ListNode();
        preHead.next=tail;
        while(list1!=null&&list2!=null){
            int v1=list1.val;
            int v2= list2.val;
            ListNode t2=new ListNode();
            if(v1<v2){
                t2.val=v1;
                list1=list1.next;
            }else{
                t2.val=v2;
                list2=list2.next;
            }
            tail.next=t2;
            tail=t2;

        }
        while(list1!=null){
            int v=list1.val;
            ListNode t=new ListNode();
            t.val=v;
            tail.next=t;
            tail=t;
            list1=list1.next;
        }
        while(list2!=null){
            int v=list2.val;
            ListNode t=new ListNode();
            t.val=v;
            tail.next=t;
            tail=t;
            list2=list2.next;
        }
        return preHead.next.next;
    }
}

public class Hot21 {
    public static void main(String[] args) {

        Solution21 s21=new Solution21();
        LinkList m = new LinkList();
//        List<Integer> list1 = Arrays.asList(1,2,4);
//        List<Integer> list2 = Arrays.asList(1,3,4);
        ListNode head1 = m.initLinkByList(Arrays.asList());
        ListNode head2 = m.initLinkByList(Arrays.asList());
        ListNode ans = s21.mergeTwoLists(head1, head2);
        System.out.println(ans);
//        m.printAll(ans);
//        m.printAll(head1);
//

//        LinkList link1 = new LinkList(head1);
//

//        LinkList link2 = new LinkList(head2);
//

//        link1.initList(list1);
//        link2.initList(list2);
//
//        ListNode ans = s21.mergeTwoLists(head1,head2);


//        link1.printAll();
//        link1.initList();
    }
}
