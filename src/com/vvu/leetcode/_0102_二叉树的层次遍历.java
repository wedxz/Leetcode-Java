package com.vvu.leetcode;

import com.vvu.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/
public class _0102_二叉树的层次遍历 {
	
    // 1 /*BFS: Counting*/
    public List<List<Integer>> levelOrder2(TreeNode root) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	if (root == null) {
			return list;
		}
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> current = new ArrayList<Integer>();
            int len = queue.size();
        	for (int i = 0; i < len; i++) {
        		TreeNode node = queue.poll();
        		if (node != null) {
        			current.add(node.val);
        			if (node.left != null) {
        				queue.add(node.left);
        			}
        			if (node.right != null) {
        				queue.add(node.right);
        			}
				}
        	}
			list.add(current);
        }
        return list;
    }
}