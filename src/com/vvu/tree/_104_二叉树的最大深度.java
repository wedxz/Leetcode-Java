package com.vvu.tree;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/
public class _104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
    	if (root == null) {
			return 0;
		}
        int heigh = 0;
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			level--;
			if (node != null) {
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			if (level == 0) {
				level = queue.size();
				heigh++;
			}
		}
        return heigh;
    }
}
