package com.vvu.sort;

import java.util.ArrayList;
import java.util.List;

// 希尔排序
public class Shell<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		List<Integer> stepSwquence = sedgewickStepSequence();
//		List<Integer> stepSwquence = shellStepSequence();
		for (Integer step : stepSwquence) {
			sort(step);
		}
	}

	private void sort(int step) {
		for (int col = 0; col < step; col++) {
			for (int begin = col + step; begin < array.length; begin += step) {
				int cur = begin;
				while (cur > col && cmp(cur, cur - step) < 0) {
					swap(cur, cur - step);
					cur -= step;
				}
			}
		}
	}
	
	// 最坏时间复杂度 O(n^2)
	@SuppressWarnings("unused")
	private List<Integer> shellStepSequence() {
		List<Integer> stepSwquence = new ArrayList<>();
		int step = array.length;
		while ((step >>= 1) > 0) {
			stepSwquence.add(step);
		}
		return stepSwquence;
	}
	
	// 最坏时间复杂度 O(n^4/3)
	private List<Integer> sedgewickStepSequence() {
		List<Integer> stepSwquence = new ArrayList<>();
		int k = 0, step = 0;
		while (true) {
			if (k % 2 == 0) {
				int pow = (int) Math.pow(2, k >> 1);
				step = 1 + 9 * (pow * pow - pow);
			} else {
				int pow1 = (int) Math.pow(2, (k - 1) >> 1);
				int pow2 = (int) Math.pow(2, (k + 1) >> 1);
				step = 1 + 8 * pow1 * pow2 - 6 * pow2;
			}
			if (step >= array.length) {
				break;
			}
			stepSwquence.add(0,step);
			k++;
		}
		return stepSwquence;
	}
}
