package com.vvu.leetcode;

import java.util.Stack;

// https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
public class _0150_逆波兰表达式求值 {
	
    public int evalRPN(String[] tokens) {
    	Stack<Integer> stack = new Stack<>();
    	stack.push(0);
    	for (int i = 0; i < tokens.length; i++) {
    		String c = tokens[i];
    		if (c.equals("+") || 
    			c.equals("-") || 
    			c.equals("*") || 
    			c.equals("/")) {
				int v = stack.pop();
				int w = stack.pop();
        		if (c.equals("+")) {
    				stack.push(w + v);
    			} else if (c.equals("-")){
    				stack.push(w - v);
    			} else if (c.equals("*")){
    				stack.push(w * v);
    			} else if (c.equals("/")){
    				stack.push(w / v);
    			} 
			} else {
				stack.push(Integer.parseInt(c));
			}
		}
    	return stack.pop();
    }
}
