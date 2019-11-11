package com.vvu.leetcode;

import java.util.Stack;

import com.vvu.tree.TreeNode;

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class _0114_二叉树展开为链表 {

	private TreeNode prev;
	// 后序遍历,递归的方式
    public void flatten(TreeNode root) {
    	if (root == null) return;
    	
    	flatten(root.right);
    	flatten(root.left);
    	if (prev != null) {
			root.right = prev;
			root.left = null;
		}
    	prev = root;
    }
    
	// 后序遍历,迭代方式
    public void flatten2(TreeNode root) {
    	if (root == null) return;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(root);
    	
    	TreeNode prev = null;
    	while (!stack.isEmpty()) {
    		TreeNode top = stack.peek();
    		boolean leaf = (top.left == null) && (top.right == null);
    		boolean preIsChild = (prev != null) && ((prev == top.left) || (prev == top.right));
    		if (leaf || preIsChild) {
    	    	if (prev != null) {
    	    		top.right = prev;
    	    		top.left = null;
    			}
    	    	prev = top;
    	    	
				stack.pop();
				prev = top;
			} else {
				if (top.left != null) {
					stack.push(top.left);
				}
				if (top.right != null) {
					stack.push(top.right);
				}
			}
		}
    }
    
    // 前序遍历 迭代的方法
    public void flatten3(TreeNode root) {
        while (root != null) {
			if (root.left != null) {
		        TreeNode oldRight = root.right;
		        root.right = root.left;
		        root.left = null;
		        TreeNode rightMost = root;
		        while (rightMost.right != null) {
		        	rightMost = rightMost.right;
				}
		        rightMost.right = oldRight;
			}
			root = root.right;
        }
    }
    
    // 逐个吧左子树放到右边,然后把右子树拼接到最右侧
    public void flatten4(TreeNode root) {
        if (root == null) return;
        TreeNode oldRight = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode rightMost = root;
        while (rightMost.right != null) {
        	rightMost = rightMost.right;
		}
        rightMost.right = oldRight;
        flatten(root.right);
    }
}
