package com.vvu.leetcode;

import com.vvu.tree.TreeNode;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class _0124_二叉树中的最大路径和 {

	private int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
    	if (root == null) return 0;
    	value(root);
    	return sum;
    }
    
    public int value(TreeNode node) {
    	if (node == null) return 0;
    	int v1 = Math.max(value(node.left), 0);
    	int v2 = Math.max(value(node.right), 0);
    	sum = Math.max(sum, node.val + v1 + v2);
    	return node.val + Math.max(v1, v2);
    }
}
