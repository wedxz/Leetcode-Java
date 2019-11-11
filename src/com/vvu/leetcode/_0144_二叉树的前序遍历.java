package com.vvu.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.vvu.tree.TreeNode;
// https://leetcode.com/problems/binary-tree-preorder-traversal/
public class _0144_二叉树的前序遍历 {
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
		list.add(root.val);
		preorderTreeNode(root.left,list);
		preorderTreeNode(root.right,list);
	}
    
    // 2
    public List<Integer> preorderTraversal2(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode cur = root;
    	while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				list.add(cur.val);
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				cur = cur.right;
			}
		}
        return list;
    }
}
