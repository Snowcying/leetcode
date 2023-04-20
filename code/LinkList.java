package code;

import java.util.List;

public class LinkList {
    static public ListNode initLinkByList(List<Integer> list1) {
        ListNode head = new ListNode();
        if (list1.size() == 0) {
            return null;
        }
        ListNode tail = new ListNode(list1.get(0));
        head.next = tail;
        for (int i = 1; i < list1.size(); i++) {
            ListNode l2 = new ListNode(list1.get(i));
            tail.next = l2;
            tail = l2;
        }
        return head.next;
    }

    //  LL.initLinkByArray(new int[]{1,2,3})
    static public ListNode initLinkByArray(int[] list1) {
        ListNode head = new ListNode();
        if (list1.length == 0) {
            return null;
        }
        ListNode tail = new ListNode(list1[0]);
        head.next = tail;
        for (int i = 1; i < list1.length; i++) {
            ListNode l2 = new ListNode(list1[i]);
            tail.next = l2;
            tail = l2;
        }
        return head.next;
    }


    static public void printAll(ListNode head) {
        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println(head.val);
    }
}
