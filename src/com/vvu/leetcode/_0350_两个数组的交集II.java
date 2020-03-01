package com.vvu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/intersection-of-two-arrays-ii/
public class _0350_两个数组的交集II {

	public int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<>();
		Arrays.sort(nums1);//排序数组
		Arrays.sort(nums2);
		int i = 0, j = 0;//定义指针
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) i++;//移动较小数的指针
			else if (nums1[i] > nums2[j]) j++;//移动较小数的指针
			else {
				//两数相等则为交集，存入动态数组，移动双指针
				list.add(nums1[i]);
				i++;
				j++;
			}
		}
		//转为数组并返回
		int[] res = new int[list.size()];
		for (int k = 0; k < list.size(); k++) res[k] = list.get(k);
		return res;
	}
	
	// 哈希表
    public int[] intersect2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();//动态数组
        for (Integer num : nums1) map.put(num, map.getOrDefault(num, 0) + 1);//统计元素出现频次
        for (Integer num : nums2) {//遍历另一个数组
            if (map.containsKey(num)) {
                int tmp = map.get(num)-1;//频次减一
                if (tmp == 0) map.remove(num);//频次为 0 时，移出 HashMap
                else map.put(num, tmp);//否则更新频次
                list.add(num);//加入动态数组
            }
        }
        //转为数组并返回
        int size=list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) res[i] = list.get(i);
        return res;
    }
}
