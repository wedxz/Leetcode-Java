package com.vvu.leetcode;

import com.vvu.list.ListNode;

// https://leetcode.com/problems/add-two-numbers/
public class _0002_两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode ret = new ListNode(0);
    	ListNode cur = ret;
    	int num = 0;
    	while (l1 != null || l2 != null) {
    		int x = 0;
    		int y = 0;
    		if (l1 != null) { x = l1.val; }
    		if (l2 != null) { y = l2.val; }
    		int sum = x + y + num;
    		num = sum / 10;
    		cur.next = new ListNode(sum % 10);
    		cur = cur.next;
    		if (l1 != null) { l1 = l1.next; }
    		if (l2 != null) { l2 = l2.next; }
    	}
    	
    	if (num > 0) {
			cur.next = new ListNode(1);
    	}
    	return ret.next;
    }
}
