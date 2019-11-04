package com.vvu.offer;

import java.util.Arrays;
import com.vvu.tree.TreeNode;

// https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
// 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字
public class _007_重建二叉树 {

	
	// 递归的方式实现
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length-1);
        return root;
    }
    
    public TreeNode reConstructBinaryTree(int [] pre, int startPre, int endPre, int [] in, int startIn, int endIn) {
    	if (startPre > endPre || startIn > endIn) {
			return null;
		}
    	TreeNode root = new TreeNode(pre[startPre]);
    	for (int i = startIn; i <= endIn; i++) {
			if (in[i] == pre[startPre]) {
				root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
				root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
			}
		}
        return root;
    }
    
    
    // 其他解法
    public TreeNode reConstructBinaryTree2(int [] pre,int [] in) {
    	if(pre.length == 0||in.length == 0){
    		return null;
    	}
    	TreeNode node = new TreeNode(pre[0]);
    	for (int i = 0; i < in.length; i++){
    		if (pre[0] == in[i]){
    			node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
    			node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1,in.length));
    		}
    	}
    	return node;
    }
}
