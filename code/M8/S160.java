package code.M8;

import code.LinkList;
import code.ListNode;

import java.util.Arrays;
import java.util.HashSet;

public class S160 {
    static public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            HashSet<ListNode> set = new HashSet<>();
            while (headA != null) {
                set.add(headA);
                headA = headA.next;
            }
            while (headB != null) {
                if (set.contains(headB)) {
                    return headB;
                }
                headB = headB.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = LinkList.initLinkByArray(new int[]{1, 9, 1, 2, 4});
        ListNode l2 = new ListNode(3);
        ListNode inter = l1.next.next.next;
        l2.next = inter;
        System.out.println(new Solution().getIntersectionNode(l1, l2));
//        while (l1!=null){
//            System.out.println(l1);
//            l1=l1.next;
//        }
//        System.out.println("---");
//        while (l2!=null){
//            System.out.println(l2);
//            l2=l2.next;
//        }
//        LinkList.printAll(l2);
    }
}
