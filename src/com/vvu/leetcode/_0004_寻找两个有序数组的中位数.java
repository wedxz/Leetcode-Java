package com.vvu.leetcode;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class _0004_寻找两个有序数组的中位数 {
    
	/*
		合并后的新数组长度为L = m+n。当L为奇数时，中位数取值为新数组index = (m+n)/2 = (m+n-1)/2处的值；当L为偶数时，
		中位数取值为新数组index = (m+n-1)/2和index = (m+n)/2值的平均值。即：中位数为新数组index = (m+n-1)/2和index = (m+n)/2值的均值。
		假设从起始位置开始计算，第k个是中位数，则start + k - 1 = index。
		
		采用二分法，不断缩小k值，递归求解：
		初始状态，原数组起始下标均为0，新数组起始下标到中位数距离为k = index + 1。
		第一次递归：二分法缩短起始下标到中位数距离，距离减半k/2，原数组起始下标增加k/2。至于是数组s1还是数组s2起始下标增加k/2，需要根据数组s1、s2截断后的数组片段中位数判断。
		第二次递归：二分法缩短起始下标到中位数距离，距离再减半(k-k/2)/2，原数组起始下标增加(k-k/2)/2。
		…………
		最终，当k == 1时，停止递归。
	 */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = (nums1.length + nums2.length + 1) / 2;
        int j = (nums1.length + nums2.length + 2) / 2;
        return (getMid(nums1, 0, nums2, 0, i) + getMid(nums1, 0, nums2, 0, j)) / 2;     //取均值
    }
    
    
    public double getMid(int[] nums1, int aStart, int[] nums2, int bStart, int k) {
        if (aStart > nums1.length - 1) return nums2[bStart + k - 1];
        if (bStart > nums2.length - 1) return nums1[aStart + k - 1];
        if (k == 1) return Math.min(nums1[aStart], nums2[bStart]);
        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < nums1.length) aMid = nums1[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < nums2.length) bMid = nums2[bStart + k/2 - 1];
        if (aMid < bMid) {      //判断选择s1、s2，移动下标位置
            return getMid(nums1, aStart + k/2, nums2, bStart, k - k/2);     //每次对半减小k值
        } else {
            return getMid(nums1, aStart, nums2, bStart + k/2, k - k/2);
        }
    }
}