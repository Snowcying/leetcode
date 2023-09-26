package code.M9;

import code.LinkList;
import code.ListNode;

import java.util.Stack;

public class S234 {
    public boolean isPalindrome(ListNode head) {
        ListNode pre = null;
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        if (quick != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != pre.val) return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }

    public ListNode reverseLink(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }

    public static void main(String[] args) {
        ListNode head = LinkList.initLinkByArray(new int[]{1});
//        ListNode newHead = new S234().reverseLink(head);
//        LinkList.printAll(newHead);
        System.out.println(new S234().isPalindrome(head));
    }
}
