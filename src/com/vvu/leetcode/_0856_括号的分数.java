package com.vvu.leetcode;
import java.util.Stack;

// https://leetcode-cn.com/problems/score-of-parentheses/
public class _0856_括号的分数 {
	
    public int scoreOfParentheses(String S) {
    	Stack<Integer> stack = new Stack<>();
    	stack.push(0);
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == '(') { // 左括号
				stack.push(0);
			} else { // 右括号
				int v = stack.pop();
				int w = stack.pop();
				stack.push(w + Math.max(2 * v, 1));
			}
		}
        return stack.pop();
    }
}