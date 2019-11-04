package com.vvu.offer;

import java.util.ArrayList;
import java.util.Stack;
import com.vvu.list.ListNode;

// https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
// 从尾到头反过来打印出每个结点的值。
public class _006_从尾到头打印链表 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> array = new ArrayList<>();
        Stack<Integer> st = new Stack<Integer>();
    	if (listNode == null) {
			return new ArrayList<>();
		}
        st.push(listNode.val);
        
        while (!st.isEmpty()) {
        	if (listNode.next != null) {
				st.push(listNode.next.val);
				listNode = listNode.next;
			} else {
				array.add(st.pop());
			}
		}
        return array;
    }
    
    // 使用递归
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> array = new ArrayList<>();
        if (listNode != null) {
			array.addAll(printListFromTailToHead(listNode.next));
			array.add(listNode.val);
		}
        return array;
    }
    
    // 插头法
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        // 头插法构建逆序链表
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }
        // 构建 ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }
    
    // 使用栈
    public ArrayList<Integer> printListFromTailToHead4(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty())
            ret.add(stack.pop());
        return ret;
    }
}
