package code.M8;

import code.LinkList;
import code.ListNode;

public class S206 {
    static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode node = head;
            while (node != null) {
                ListNode next = node.next;
                node.next = pre;
                pre = node;
                node = next;
            }
            return pre;
        }
    }

    public static void main(String[] args) {
        ListNode input = LinkList.initLinkByArray(new int[]{1, 2, 3, 4, 5});
        ListNode newHead = new Solution().reverseList(input);
        LinkList.printAll(newHead);
//        System.out.println(new Solution().reverseList(input).val);
    }
}
