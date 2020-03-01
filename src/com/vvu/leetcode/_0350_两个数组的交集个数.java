package com.vvu.leetcode;

import java.util.Arrays;

// A、B两个数组中相同的元素,在A的出现的次数
public class _0350_两个数组的交集个数 {

    public void test(int[] nums1, int[] nums2) {
    	Arrays.sort(nums1);
	    Arrays.sort(nums2);
        int i = 0, j = 0, k = 0, m = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
				m = nums1[i];
				while (i < nums1.length && nums1[i] == m) {
					i++;
					k++;
				}
		     	System.out.println(m + " " + k);
		     	k = 0;
		     	j++;
            } else {
            	if (nums1[i] < nums2[j]) {
					i++;
				} else {
					j++;
				}
            }
        }
    }
    
    // 测试
    public static void main(String[] args) {
		int[] nums1 = {1,1,1,2,2,3,3};
		int[] nums2 = {1,1,1,2,2,3};
		new _0350_两个数组的交集个数().test(nums1, nums2);
    }
}
