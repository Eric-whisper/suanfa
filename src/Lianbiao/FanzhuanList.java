package Lianbiao;

import java.util.List;


//反转链表
public class FanzhuanList {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = head.next;
        }
        return prev;
    }
}
