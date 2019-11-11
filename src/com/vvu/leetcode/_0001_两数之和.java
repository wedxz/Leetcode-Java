package com.vvu.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
public class _0001_两数之和 {
	
    public int[] twoSum(int[] nums, int target) {
    	int[] array = new int[2];
    	Map<Integer, Integer> map = new HashMap<>();
    	for (int i = 0; i < nums.length; i++) {
    		int complement = target - nums[i];
    		//  
    		if (map.containsKey(complement)) {
    			array[0] = map.get(complement);
    			array[1] = i;
    			break;
    		}
    		map.put(nums[i], i);
    	}
        return array;
    }
}
