package com.vvu.leetcode;
import com.vvu.list.ListNode;

// https://leetcode.com/problems/reverse-linked-list/
public class _0206_反转链表 {
	
	// 递归方式
    public ListNode reverseList(ListNode head) {
    	if (head == null || head.next == null) {
			return head;
		}
    	ListNode newHead = reverseList(head.next);
    	head.next.next = head;
    	head.next = null;
    	return newHead;
    }
    
    // 遍历方式
    public ListNode reverseList2(ListNode head) {
    	if (head == null || head.next == null) {
			return head;
		}
    	ListNode newHead = null;
    	while (head != null) {
			ListNode tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
    	return newHead;
    }
}
