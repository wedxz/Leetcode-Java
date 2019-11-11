package com.vvu.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/valid-sudoku/
@SuppressWarnings("unchecked")
public class _0036_有效的数独 {

	// 二进制存储状态
    public boolean isValidSudoku2(char[][] board) {
		short[] rows = new short[9];
		short[] cols = new short[9];
		short[] boxes = new short[9];
		
    	for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				char num = board[row][col];
				if (num == '.') {
					continue;
				}
				num = (char) (1 << (num - '1'));
				int boxIndex = (row / 3) * 3 + col / 3;
				
				if ((rows[row] & num) != 0) {
					return false;
				}
				if ((cols[col] & num) != 0) {
					return false;
				}
				if ((boxes[boxIndex] & num) != 0) {
					return false;
				}
				rows[row] += num;
				cols[col] += num;
				boxes[boxIndex] += num;
			}
		}
    	return true;
    }
    
    // 二维数组
    public boolean isValidSudoku3(char[][] board) {
		boolean[][] rows = new boolean[9][9];
		boolean[][] cols = new boolean[9][9];
		boolean[][] boxes = new boolean[9][9];
		
    	for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				char num = board[row][col];
				if (num == '.') {
					continue;
				}
				num -= '1';
				int boxIndex = (row / 3) * 3 + col / 3;
				if (rows[row][num]) {
					return false;
				}
				if (cols[col][num]) {
					return false;
				}
				if (boxes[boxIndex][num]) {
					return false;
				}
				rows[row][num] = true;
				cols[col][num] = true;
				boxes[boxIndex][num] = true;
			}
		}
    	return true;
    }
    
    // Set 比较
    public boolean isValidSudoku4(char[][] board) {
		Set<Character>[] rows = new Set[9];
    	Set<Character>[] cols = new Set[9];
    	Set<Character>[] boxes = new Set[9];
    	
    	for (int i = 0; i < 9; i++) {
			rows[i] = new HashSet<Character>();
			cols[i] = new HashSet<Character>();
			boxes[i] = new HashSet<Character>();
		}
    	
    	for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				char num = board[row][col];
				if (num == '.') {
					continue;
				}
				int boxIndex = (row / 3) * 3 + col / 3;
				if (rows[row].contains(num)) {
					return false;
				}
				if (cols[col].contains(num)) {
					return false;
				}
				if (boxes[boxIndex].contains(num)) {
					return false;
				}
				rows[row].add(num);
				cols[col].add(num);
				boxes[boxIndex].add(num);
			}
		}
    	return true;
    }
}
