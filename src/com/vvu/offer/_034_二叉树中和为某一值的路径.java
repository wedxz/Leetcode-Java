package com.vvu.offer;

import java.util.ArrayList;
import com.vvu.tree.TreeNode;

// https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
// 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

public class _034_二叉树中和为某一值的路径 {
	
	private ArrayList<ArrayList<Integer>> array = new ArrayList<>();
	
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {  
    	backTracking(root, target, new ArrayList<Integer>());
    	return array;
    }
    
    private void backTracking(TreeNode node, int target, ArrayList<Integer> path) {
    	if (node == null) {
			return;
		}
    	path.add(node.val);
    	target -= node.val;
    	if (target == 0 && node.left == null && node.right == null) {
			array.add(new ArrayList<>(path));
		} else {
			backTracking(node.left, target, path);
			backTracking(node.right, target, path);
		}
    	path.remove(path.size() - 1);
    }
}
