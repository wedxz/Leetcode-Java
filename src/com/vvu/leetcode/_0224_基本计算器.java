package com.vvu.leetcode;
import java.util.Stack;

// https://leetcode-cn.com/problems/basic-calculator/
public class _0224_基本计算器 {
	
    public int calculate(String s) {
    	Stack<Integer> stack = new Stack<>();
     	int res = 0;
     	int sign = 1;
    	for (int i=0; i<s.length(); i++) {
    		char c = s.charAt(i);
    		if (Character.isDigit(c)) {
				int cur = c - '0';
				while (i+1 < s.length() && Character.isDigit(s.charAt(i+1)) ) {
					cur = 10 * cur + s.charAt(++i) - '0';
				}
				res += sign * cur;
			} else if (c == '+') {
				sign = 1;
			} else if (c == '-') {
				sign = -1;
			} else if (c == '(') {
				stack.push(res);
				res = 0;
				stack.push(sign);
				sign = 1;
			} else if (c == ')') {
				res = stack.pop() * res + stack.pop();
				sign = 1;
			}
		}
    	return res;
    }
}
