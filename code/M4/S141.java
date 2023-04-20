package code.M4;

import code.LinkList;
import code.ListNode;

import java.util.HashMap;
import java.util.Map;

public class S141 {
    //    public static boolean hasCycle(ListNode head) {
//        if(head==null) return false;
//        Map<ListNode,Boolean> m1=new HashMap<>();
////        m1.put(head,true);
//        while(!m1.containsKey(head)&&head.next!=null){
//            m1.put(head,true);
//            head=head.next;
//        }
//        if(head.next==null){
//            return false;
//        }
//        return m1.containsKey(head);
//    }
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode quick = head.next;
        while (slow != quick) {
            if (quick == null || quick.next == null) return false;
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 0, -4};
        int pos = 1;
        ListNode head = LinkList.initLinkByArray(nums);
        ListNode pre = head;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        while (pos > 0) {
            pre = pre.next;
            pos--;
        }
        tail.next = pre;
        System.out.println(hasCycle(head));
//        LinkList.printAll(head);

    }
}
