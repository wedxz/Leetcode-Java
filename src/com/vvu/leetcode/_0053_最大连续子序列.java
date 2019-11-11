package com.vvu.leetcode;

public class _0053_最大连续子序列 {
	
    public static int maxSubArray(int[] nums) {
		int maxResult = nums[0];
		int maxTmp = 0;
		for (int i = 0; i < nums.length; i++) {
			if (maxTmp >= 0) {
				maxTmp += nums[i];
			} else {
				maxTmp = nums[i];
			}
			if (maxTmp > maxResult) {
				maxResult = maxTmp;
			}
		}
		return maxResult;
    }
    
    public static void main(String[] args){
    	int[] A = {1,-2,3,10};
    	System.out.println(maxSubArray(A));
    }
}
