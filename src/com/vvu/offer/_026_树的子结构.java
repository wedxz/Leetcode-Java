package com.vvu.offer;

import com.vvu.tree.TreeNode;

// https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=11170&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
public class _026_树的子结构 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    	if (root1 == null || root2 == null) {
			return false;
		}
    	return isSubtreeWithRoot(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
    
    private boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
    	if (root2 == null) {
			return true;
		}
    	if (root1 == null) {
			return false;
		}
    	if (root1.val != root2.val) {
			return false;
		}
    	return isSubtreeWithRoot(root1.left, root2.left) && isSubtreeWithRoot(root1.right, root2.right);
    }
}
