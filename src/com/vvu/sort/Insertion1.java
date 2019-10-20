package com.vvu.sort;

public class Insertion1<T extends Comparable<T>> extends Sort<T> {
	
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
	
}
