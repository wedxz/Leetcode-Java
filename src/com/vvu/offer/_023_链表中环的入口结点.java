package com.vvu.offer;

import com.vvu.list.ListNode;

// https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
public class _023_链表中环的入口结点 {
	
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
			return null;
		}
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
				if (fast == slow) {
					ListNode newSlow = pHead;
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
