package com.vvu.sort;

// 冒泡排序
public class Bubble<T extends Comparable<T>> extends Sort<T>  {
	
	@Override
	protected void sort() {
		for (int end = array.length - 1; end > 0; end--) {
			int sortedIndex = 1;
			for (int begin = 1; begin <= end; begin++) {
				if (cmp(begin, begin-1) < 0) {
					swap(begin, begin-1);
					sortedIndex = begin;
				}
			}
			end = sortedIndex;
		}
	}
	
	static void bubbleSort1(Integer[] array) {
		for (int end = array.length - 1; end > 0; end--) {
			for (int begin = 1; begin <= end; begin++) {
				if (array[begin] < array[begin - 1]) {
					Integer tmp = array[begin];
					array[begin] = array[begin -1];
					array[begin - 1] = tmp;
				}
			}
		}
	}
	
	
	static void bubbleSort2(Integer[] array) {
		for (int end = array.length - 1; end > 0; end--) {
			boolean sorted = true; 
			for (int begin = 1; begin <= end; begin++) {
				if (array[begin] < array[begin - 1]) {
					Integer tmp = array[begin];
					array[begin] = array[begin -1];
					array[begin - 1] = tmp;
					sorted = false;
				}
				if (sorted) {
					break;
				}
			}
		}
	}
	
	
	static void bubbleSort3(Integer[] array) {
		for (int end = array.length - 1; end > 0; end--) {
			int sortedIndex = 1;
			for (int begin = 1; begin <= end; begin++) {
				if (array[begin] < array[begin - 1]) {
					Integer tmp = array[begin];
					array[begin] = array[begin -1];
					array[begin - 1] = tmp;
					sortedIndex = begin;
				}
			}
			end = sortedIndex;
		}
	}
}
