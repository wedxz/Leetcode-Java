package com.vvu.leetcode;

import com.vvu.list.ListNode;
// https://leetcode-cn.com/problems/merge-two-sorted-lists/
public class _0021_合并两个有序链表 {

    // 递归的方式实现
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        if (l1.val <= l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
    }
    
    // 迭代的方式实现
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				cur.next = l1;
				cur = cur.next;
				l1 = l1.next;
			} else {
				cur.next = l2;
				cur = cur.next;
				l2 = l2.next;
			}
		}
        
        if (l1 == null) {
			cur.next = l2;
		} else if (l2 == null) {
			cur.next = l1;
		}
        return head.next;
    }
}
