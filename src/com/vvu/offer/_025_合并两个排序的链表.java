package com.vvu.offer;

import com.vvu.list.ListNode;

// https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github

public class _025_合并两个排序的链表 {
	
	// 迭代的方式
	public ListNode Merge(ListNode list1,ListNode list2) {
    	ListNode head = new ListNode(-1);
     	ListNode node = head;
    	while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				node.next = list1;
				list1 = list1.next;
			} else {
				node.next = list2;
				list2 = list2.next;
			}
			node = node.next;
		}
    	
    	if (list1 != null) {
    		node.next = list1;
		}
    	if (list2 != null) {
    		node.next = list2;
		}
    	return head.next;
    }
	
	// 递归的方式
	public ListNode Merge2(ListNode list1,ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		if (list1.val <= list2.val) {
			list1.next = Merge2(list1.next, list2);
			return list1;
		} else {
			list2.next = Merge2(list1, list2.next);
			return list2;
		}
    }
}
