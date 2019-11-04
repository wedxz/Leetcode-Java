package com.vvu.offer;

import com.vvu.tree.TreeNode;

// https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=11211&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
public class _028_对称的二叉树 {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
			return true;
		}
        return isSymmetrical(pRoot.left, pRoot.right);
    }
    
    private boolean isSymmetrical(TreeNode left, TreeNode right) {
    	if (left == null && right == null) {
			return true;
		}
    	if (left == null || right == null) {
			return false;
		}
    	if (left.val != right.val) {
			return false;
		}
    	return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }
}
