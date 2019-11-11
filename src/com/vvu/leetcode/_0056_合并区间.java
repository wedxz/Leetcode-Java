package com.vvu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/merge-intervals/
public class _0056_合并区间 {
	
    public static int[][] merge(int[][] array) {
   	 	if (array.length == 0) {
   	 		return new int[0][0];
   	 	}
   	 	// 先排序
   	 	Arrays.sort(array, (int[] v1, int[] v2) -> {
   	 		return Integer.compare(v1[0], v2[0]);
   	 	});
   
   	 	// 取出数组的每一位进行比较
   	 	ArrayList<int[]> list = new ArrayList<>();
   	 	int[] cur = array[0];
   	 	for (int i = 1; i < array.length; i++) {
   	 		int[] tmp = array[i];	
   	 		// 第一个区间的右端 与 第二个区间的左端进行比较
   	 		if (cur[1] >= tmp[0]) {
   	 			cur = mergeTwoArray(cur, tmp);
   	 		} else {
   	 			list.add(cur);
   	 			cur = tmp;
   	 		}
   	 	}
   	 	// 最后再添加
   	 	list.add(cur);
   	 	int[][] resultArray = new int[list.size()][2];
   	 	for (int i = 0; i < list.size(); i++) {
   	 		resultArray[i] = list.get(i);
   	 	}
   	 	return resultArray;
    }
    
    public static int[] mergeTwoArray(int[] v1, int[] v2) {
		int[] array = new int[2];
		array[0] = Math.min(v1[0], v2[0]);
		array[1] = Math.max(v1[1], v2[1]);
		return array;
	}
    
    // 测试
    public static void main(String[] args) {
        int A[][]={{1,3},{2,6},{8,9}};
        A = merge(A);
        for (int i = 0; i < A.length; i++) {
        	System.out.println(Arrays.toString(A[i]));
		}
    
    }
}
