package com.vvu.offer;

import com.vvu.list.ListNode;

// https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
public class _024_反转链表 {
	
    public ListNode ReverseList(ListNode head) {
    	if (head == null || head.next == null) {
			return head;
		}
    	ListNode newNode = null;
    	while (head != null) {
    		ListNode tmp = head.next;
    		head.next = newNode;
    		newNode = head;
    		head = tmp;
		}
    	return newNode;
    }
}
