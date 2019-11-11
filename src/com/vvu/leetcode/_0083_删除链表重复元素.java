package com.vvu.leetcode;
import java.util.HashMap;
import com.vvu.list.ListNode;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class _0083_删除链表重复元素 {
	public ListNode deleteDuplicates(ListNode head) {
	    if (head == null) {
			return null;
		}
	    HashMap<Integer, Integer> map = new HashMap<>();
	    ListNode temp = head;
	    while (temp != null && temp.next != null) {
			if (map.containsKey(Integer.valueOf(temp.next.val))) {
				temp.next = temp.next.next;
			} else {
				map.put(Integer.valueOf(temp.next.val), Integer.valueOf(0));
				temp = temp.next;
			}
		}
	    if (map.containsKey(Integer.valueOf(head.val))) {
			head = head.next;
		}
	    return head;
	}
}
