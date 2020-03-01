package com.vvu.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/intersection-of-two-arrays/
public class _0349_两个数组的交集 {
	
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for (int num : nums1) {
            set1.add(num);
        }
        
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        
        int[] ret = new int[set2.size()];
        int i = 0;
        for (int num : set2) {
            ret[i++] = num;
        }
        return ret;
    }
}
