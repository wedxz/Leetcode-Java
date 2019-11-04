package com.vvu.offer;

// 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999

public class _017_打印从1到最大的n位数 {

	public void print1ToMaxOfNDigits(int n) {
		int num = 0;
		for (int i = 0; i < n; i++) {
			num *= 10;
		}
		
		for (int i = 1; i < num; i++) {
			System.out.println(i);
		}
	}
}
