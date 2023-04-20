package code.M4;

import code.LinkList;
import code.ListNode;

import java.util.HashSet;
import java.util.Set;

public class S142 {
    //    public static ListNode detectCycle(ListNode head) {
//        if(head==null||head.next==null) return null;
//        Set<ListNode> s1=new HashSet<>();
//        ListNode node=head;
//        while(node!=null&&!s1.contains(node)){
//            s1.add(node);
//            node=node.next;
//        }
//        return node;
//    }
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null) {
            if (quick.next == null) return null;
            slow = slow.next;
            quick = quick.next.next;
            if (quick == slow) break;
        }
        if (quick == null) return null;
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }


    public static void main(String[] args) {
//        int[] nums = {3, 2, 0, -4};
        int[] nums = {1, 2};
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
//        tail.next = pre;
        System.out.println(detectCycle(head));
    }
}
