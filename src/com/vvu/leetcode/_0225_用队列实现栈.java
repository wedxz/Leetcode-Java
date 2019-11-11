package com.vvu.leetcode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/implement-stack-using-queues/submissions/
public class _0225_用队列实现栈 {
	
	Queue<Integer> q1, q2;
    /** Initialize your data structure here. */
    public _0225_用队列实现栈() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        while (!q2.isEmpty()) {
			q1.add(q2.poll());
		}
        q2.add(x);
        while (!q1.isEmpty()) {
        	q2.add(q1.poll());
		}
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q2.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return q2.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q2.isEmpty();
    }
}
