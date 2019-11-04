package com.vvu.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import com.vvu.tree.TreeNode;

// https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701?tpId=13&tqId=11175&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
public class _032_从上往下打印二叉树 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	ArrayList<Integer> array = new ArrayList<Integer>();
    	if (root == null) {
			return array;
		}
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			array.add(node.val);
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
        return array;
    }
}
