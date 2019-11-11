package com.vvu.leetcode;

// https://leetcode.com/problems/house-robber/
public class _0198_打家劫舍 {
	
	// 优化代码
    public int rob(int[] nums) {
    	if (nums == null) return 0;
    	int first = 0, second = 0;
    	for (int i = 0; i < nums.length; i++) {
    		int tmp = second;
			second = Math.max(nums[i] + first, second);
			first = tmp;
		}
        return second;
    }
    
	// 优化空间
    public int rob1(int[] nums) {
    	if (nums == null || nums.length == 0) return 0;
    	if (nums.length == 1) return nums[0];
    	
    	int first = nums[0];
    	int second = Math.max(nums[0], nums[1]);
    	for (int i = 2; i < nums.length; i++) {
    		int tmp = second;
			second = Math.max(nums[i] + first, second);
			first = tmp;
		}
        return second;
    }
    
    // 缓存计算结果 
    public int rob2(int[] nums) {
    	if (nums == null || nums.length == 0) return 0;
    	if (nums.length == 1) return nums[0];
    	
    	int[] array = new int[nums.length];
    	array[0] = nums[0];
    	array[1] = Math.max(nums[0], nums[1]);
    	for (int i = 2; i < array.length; i++) {
			array[i] = Math.max(nums[i] + array[i - 2], array[i - 1]);
		}
        return array[array.length - 1];
    }
    
    
	// 解题思路: 每个房子 偷于不偷
	// 如果偷0号房间
	// sum1 = nums[0] + rob([1,2,3,4,5])
	// 如果不偷0号房间
	// sum2 = rob([1,2,3,4,5])
	
    public int rob3(int[] nums) {
    	if (nums == null || nums.length == 0) {
			return 0;
		}
        return rob(nums, 0);
    }
    
    // 从begin 号房子开始偷 从前往后偷
    // T(n) = T(n - 2) + T(n -1) + O(1)
    // 时间时间复杂度 O(2^n);
    public int rob(int[] nums, int begin) {
    	if (begin == nums.length -1) {
			return nums[begin];
		}
    	if (begin == nums.length - 2) {
			return Math.max(nums[begin], nums[begin + 1]);
		}
    	int robCur = nums[begin] + rob(nums, begin + 2);
    	int robNext = rob(nums, begin + 1);
        return Math.max(robCur, robNext);
    }
}
