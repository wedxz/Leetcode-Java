package com.vvu.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import com.vvu.tree.TreeNode;

public class _0226_翻转二叉树 {
	
	// 层次遍历
    public TreeNode invertTree(TreeNode root) {
        if (root == null) { return root; }
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		return root;
    }
    
    // 前序遍历
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) { return root; }
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
        invertTree1(root.left);
        invertTree1(root.right);
		return root;
    }
    
    // 中序遍历
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) { return root; }
        invertTree2(root.left);
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
        invertTree2(root.left);
		return root;
    }
    
    // 后序遍历
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) { return root; }
        invertTree3(root.left);
        invertTree3(root.right);
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
		return root;
    }
}
