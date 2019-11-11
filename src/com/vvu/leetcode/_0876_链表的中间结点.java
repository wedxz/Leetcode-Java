package com.vvu.leetcode;

import com.vvu.list.ListNode;

//https://leetcode.com/problems/middle-of-the-linked-list/solution/
public class _0876_链表的中间结点 {
	
    public ListNode middleNode(ListNode head) {
    	ListNode[] A = new ListNode[100];
    	int t = 0;
    	while (head.next != null) {
			A[t++] = head;
			head = head.next;
		}
        return A[t/2];
    }
}
