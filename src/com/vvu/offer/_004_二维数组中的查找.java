package com.vvu.offer;

// https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github

public class _004_二维数组中的查找 {
	
    public boolean Find(int target, int [][] array) {
		if (array == null || array.length == 0 || array[0].length == 0) {
			return false;
		}
		int row = 0;
		int col = array[0].length - 1;
		while (row < array.length && col >= 0) {
			if (target > array[row][col]) {
				row++;
			} else if (target < array[row][col]) {
				col--;
			} else {
				return true;
			}
		}
		return false;
    }
}
