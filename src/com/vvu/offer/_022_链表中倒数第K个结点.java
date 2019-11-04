package com.vvu.offer;

import com.vvu.list.ListNode;

// https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
// 
public class _022_链表中倒数第K个结点 {

    public ListNode FindKthToTail(ListNode head,int k) {
    	if (head == null) {
			return null;
		}
    	ListNode p1 = head;
    	ListNode p2 = head;
    	while (p1 != null && k-- > 0) {
    		p1 = p1.next;
		}
    	if (k > 0) {
			return null;
		}
    	while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
    	return p2;
    }
}
