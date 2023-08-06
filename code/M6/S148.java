package code.M6;

import code.LinkList;
import code.ListNode;

public class S148 {
    public static ListNode sortList(ListNode head) {
        ListNode returnHead = head;
        ListNode start = new ListNode(-1);
        start.next = head;
        while (start.next != null) {
            while (head.next != null) {
                if (head.next.val < start.next.val) {
                    int temp = head.next.val;
                    head.next.val = start.next.val;
                    start.next.val = temp;
                }
                head = head.next;
            }
            start = start.next;
            head = start.next;
        }
        return returnHead;
    }

    public static void main(String[] args) {
        System.out.println("148");
//        int[] input={4,2,1,3};
        int[] input = {-1};

        ListNode head = LinkList.initLinkByArray(input);
        head = sortList(head);
        LinkList.printAll(head);
//        sortList()
    }
}
