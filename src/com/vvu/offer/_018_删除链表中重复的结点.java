package com.vvu.offer;

import java.util.HashMap;
import com.vvu.list.ListNode;

// https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
public class _018_删除链表中重复的结点 {
	
	// 递归方式
    public ListNode deleteDuplication(ListNode pHead) {
    	if (pHead == null || pHead.next == null) {
			return pHead;
		}
    	ListNode next = pHead.next;
    	if (pHead.val == next.val) {
			while (next != null && pHead.val == next.val) {
				next = next.next;
			}
			return deleteDuplication(next);
		} else {
			pHead.next = deleteDuplication(pHead.next);
			return pHead;
		}
    }
    
    // 利用遍历 没有做完
//    public ListNode deleteDuplication2(ListNode pHead) {
//    	if (pHead == null || pHead.next == null) {
//			return pHead;
//		}
//    	ListNode node = pHead;
//    	ListNode preNode = pHead;
//    	HashMap<Integer, Integer> map = new HashMap<>();		
//    	while (node.next != null) {
//    		if (map.containsKey(node.next.val)) {
//				node = preNode;
//				node.next = node.next.next;
//			} else {
//				Integer A = Integer.valueOf(node.next.val);
//				map.put(A, 0);
//				preNode = node;
//				node = node.next;
//			}
//		}
//    	if (map.containsKey(pHead.val)) {
//    		pHead = pHead.next;
//		}
//    	return pHead;
//    }
}
