package com.vvu.leetcode;

import com.vvu.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
public class _0145_二叉树的后序遍历 {

    public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
    	preorderTreeNode(root,list);
        return list;
    }
    
	// 递归的方式
    public void preorderTreeNode(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		preorderTreeNode(root.left,list);
		preorderTreeNode(root.right,list);
		list.add(root.val);
	}
    
    // 迭代的方式
    public List<Integer> preorderTraversal2(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode cur = root;
    	TreeNode q = null;
    	while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.peek();
				if (cur.right != null & cur.right != q) {
					cur = cur.right;
				} else {
					list.add(cur.val);
					cur = stack.pop();
					q = cur;
					cur = null;
				}
			}
		}
        return list;
    }
}
