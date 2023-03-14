package code;


import java.util.Arrays;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class LinkList {
//    ListNode head;

    //    LinkList(){
//
//    }
//    LinkList(ListNode listNode){
//        this.head=listNode;
//    }
    ListNode initLinkByList(List<Integer> list1) {
        ListNode head = new ListNode();
        if(list1.size()==0){
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

    void printAll(ListNode head) {
        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println(head.val);
    }
}

class Solution19 {


    void printAll(ListNode head) {
        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println(head.val);
    }

    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l1 = new ListNode();
        ListNode h = head;
        h = head;
        int len = 1;
        while (h.next != null) {
            h = h.next;
            len++;
        }
        int depth = len - n;
        ListNode pre = new ListNode(0, head);
        ListNode start = pre;
        h = head;
        while (depth > 0) {
            pre = h;
            h = h.next;
            depth--;
        }
        pre.next = h.next;
        return start.next;
    }
}

public class Hot19 {
    //    Solution19 s1 = new Solution19();
    public static void main(String[] args) {
        Solution19 s1 = new Solution19();
        LinkList m = new LinkList();
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        ListNode l1 = m.initLinkByList(list1);
//    s1.printAll(l1);
        s1.printAll(s1.removeNthFromEnd(l1, 5));
//    ListNode ans=s1.removeNthFromEnd(l1,5);


//    System.out.println(s1);
    }
}
