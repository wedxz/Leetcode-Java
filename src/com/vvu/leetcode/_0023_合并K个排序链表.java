package com.vvu.leetcode;

import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import com.vvu.list.ListNode;

// https://leetcode.com/problems/merge-k-sorted-lists/
public class _0023_合并K个排序链表 {
	
	// 使用分治策略 O(nlogk)
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
			return null;
		}
        
        int step = 1;
        while (step < lists.length) {
        	int nextStep = step << 1;
            for (int i = 0; i + step < lists.length; i += nextStep) {
    			lists[i] = mergeTwoLists(lists[i], lists[i + step]);
    		}
            step = nextStep;
		}
        return lists[0];
    }
    
	// 使用优先级队列 小顶堆 时间复杂度 O(nlogK)
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
			return null;
		}
        // 将排序好的节点串起来
        ListNode head = new ListNode(0);
        ListNode cur = head;
        
        // 将所有链表的头节点添加到小顶堆 (优先级队列) 中
        PriorityQueue<ListNode> queue = new PriorityQueue<>((ListNode node1, ListNode node2) -> {
        	return node1.val - node2.val;
        });
        for (ListNode list : lists) {
    	   if (list == null) continue;
    	   queue.offer(list);
        }
       
        // 不断删除堆顶元素, 并且宝堆顶元素的 next 添加到堆中
        while (!queue.isEmpty()) {
        	ListNode node = queue.poll();
        	cur = cur.next = node;
        	if (node.next != null) {
        		queue.offer(node.next);
        	}
        }
        return head.next;
    }
    
	// 逐一和第一个合并  时间复杂度 O(kn)
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
			return null;
		}
        for (int i = 0; i < lists.length; i++) {
			lists[0] = mergeTwoLists(lists[0],lists[i]);
		}
        return lists[0];
    }
    
	// 逐一比较  时间复杂度 O(kn)
    public ListNode mergeKLists4(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
			return null;
		}
        // 将排序好的节点串起来
        ListNode head = new ListNode(0);
        ListNode cur = head;
        
        while (true) {
            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
    			if (lists[i] == null) {
    				continue;
    			}
    			if (minIndex == -1 || lists[i].val < lists[minIndex].val) {
    				minIndex = i;
    			}
    		}
            if (minIndex == -1) {
				break;
			}
            cur = cur.next = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
		}
        return head.next;
    }
    
	// 最笨的方法
    public ListNode mergeKLists5(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
			return null;
		}
        
        // 将所有节点添加到数组中
        List<ListNode> nodes = new ArrayList<>();
        for (ListNode list : lists) {
			while (list != null) {
				nodes.add(list);
				list = list.next;
			}
		} //O(n)
        
        // 对数组进行排序 O(nlogn)
        nodes.sort((ListNode node1, ListNode node2) -> {
        	return node1.val - node2.val;
        });
        
        // 将排序好的节点串起来
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (ListNode node : nodes) {
			cur = cur.next = node;
		} // O(n)
        return head.next;
    }
    
    // Other
    // 迭代的方式实现 时间复杂度 O(nlogn)  空间复杂度 O(n)
    private  ListNode head = new ListNode(0);
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        head.next = null;
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
