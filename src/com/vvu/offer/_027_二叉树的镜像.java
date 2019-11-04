package com.vvu.offer;

import com.vvu.tree.TreeNode;

//https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github

public class _027_二叉树的镜像 {

    public void Mirror(TreeNode root) {
        if (root == null) {
			return;
		}
        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }
    
    private void swap(TreeNode root) {
    	TreeNode tmp = root.left;
    	root.left = root.right;
    	root.right = tmp;
    }
}
