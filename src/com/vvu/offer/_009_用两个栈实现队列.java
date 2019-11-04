package com.vvu.offer;

import java.util.Stack;

// https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
// 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作
public class _009_用两个栈实现队列 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
    	stack1.push(node);
    }
    
    public int pop() {
        if (stack2.empty()) {
	        while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
    	return stack2.pop();
    }
}
