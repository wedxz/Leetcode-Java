package com.vvu.leetcode;

import com.vvu.list.ListNode;

// https://leetcode.com/problems/linked-list-cycle-ii/
public class _0142_环形链表II {
    public ListNode detectCycle(ListNode head) {
    	if (head == null || head.next == null) {
			return null;
		}
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
            if (fast == slow) {
            	ListNode newSlow = head;
            	while (newSlow != slow) {
					newSlow = newSlow.next;
					slow = slow.next;
				}
            	return slow;
            }
        }
        return null;
    }
}
