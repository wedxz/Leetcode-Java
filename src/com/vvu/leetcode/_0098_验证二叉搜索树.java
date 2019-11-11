package com.vvu.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import com.vvu.tree.TreeNode;

public class _0098_验证二叉搜索树 {
	private Integer last;
	private Queue<TreeNode> queue = new LinkedList<>();
	private Queue<Integer> mins = new LinkedList<>();
	private Queue<Integer> maxs = new LinkedList<>();
	
	// 通过优先级队列, 进行层次遍历
    public boolean isValidBST(TreeNode root) {
    	if (root == null) return true;
		offer(root, null, null);
    	while (!queue.isEmpty()) {
    		TreeNode node = queue.poll();
    		Integer min = mins.poll();
    		Integer max = maxs.poll();
    		
        	if (min != null && node.val <= min) return false;
          	if (max != null && node.val >= max) return false;
          	
			if (node.left != null) {
				offer(node.left, min, node.val);
			}
			if (node.right != null) {
				offer(node.right, node.val, max);
			}
		}
    	return true;
    }
    
    private void offer(TreeNode node, Integer min, Integer max) {
		queue.offer(node);
		mins.offer(min);
    	maxs.offer(max);
    }
    
	// 通过判断元素的区间  
    public boolean isValidBST2(TreeNode root) {
    	if (root == null) return true;
        return isValidBST(root, null, null);
    }
    
    public boolean isValidBST(TreeNode node, Integer min, Integer max) {
    	if (node == null) return true;
    	
    	if (min != null && node.val <= min) return false;
      	if (max != null && node.val >= max) return false;
      	
      	if (!isValidBST(node.left, min, node.val)) return false;
      	if (!isValidBST(node.right, node.val, max)) return false;
        return true;
    }
    
	// 二叉搜索树中遍历就是有序的集合  O(n)  
    public boolean isValidBST4(TreeNode root) {
    	if (root == null) return true;
    	
    	if (!isValidBST4(root.left)) return false;
    	if (last != null && root.val <= last) return false;
    	last = root.val;
    	if (!isValidBST4(root.right)) return false;
        return true;
    }
    
    // 通过迭代的方式进行 中序遍历
    public boolean isValidBST5(TreeNode root) {
    	if (root == null) return true;
    	
    	Stack<TreeNode> stack = new Stack<>();
    	Integer last = null;
    	while (true) {
    		while (root != null) {
				stack.push(root);
				root = root.left;
			}
    		if (stack.isEmpty()) break;
    		root = stack.pop();
        	if (last != null && root.val <= last) return false;
           	last = root.val;
           	root = root.right;
		}    	
        return true;
    }
}
