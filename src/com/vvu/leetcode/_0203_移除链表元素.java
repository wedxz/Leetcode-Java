package com.vvu.leetcode;

import com.vvu.list.ListNode;

// https://leetcode-cn.com/problems/remove-linked-list-elements/
public class _0203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
			return null;
		}
        ListNode temp = head;
        while (temp != null && temp.next != null) {
			if (temp.next.val == val) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
        if (head.val == val) {
			head = head.next;
		}
        return head;
    }
}
