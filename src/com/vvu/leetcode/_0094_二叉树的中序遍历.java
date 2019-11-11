package com.vvu.leetcode;

import com.vvu.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class _0094_二叉树的中序遍历 {
	// 1
    public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
    	preorderTreeNode(root,list);
        return list;
    }
    
    public void preorderTreeNode(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		preorderTreeNode(root.left,list);
		list.add(root.val);
		preorderTreeNode(root.right,list);
	}
    
    // 2
    public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
	  	Stack<TreeNode> stack = new Stack<TreeNode>();
	  	TreeNode cur = root;
    	while (cur != null || !stack.empty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				list.add(cur.val);
				cur = cur.right;
			}
		}
        return list;
    }
}
