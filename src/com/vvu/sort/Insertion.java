package com.vvu.sort;

// 插入排序
public class Insertion<T extends Comparable<T>> extends Sort<T>  {
	
	@Override
	protected void sort() {
		for (int begin = 1; begin < array.length; begin++) {
			int cur = begin;
			while(cur > 0 && cmp(cur, cur - 1) < 0) {
				swap(cur, cur-1);
				cur--;
			}
		}
	}
	
	// 优化
	protected void sort2() {
		for (int begin = 1; begin < array.length; begin++) {
			int cur = begin;
			T v = array[cur];
			while(cur > 0 && cmp(v, array[cur - 1]) < 0) {
				swap(cur, cur-1);
				array[cur] = array[cur - 1];
				cur--;
			}
			array[cur] = v;
		}
	}
}
