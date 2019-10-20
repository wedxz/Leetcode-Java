package com.vvu.sort;

import com.vvu.sort.Student;
import java.text.DecimalFormat;

@SuppressWarnings("unchecked")
public abstract class Sort<T extends Comparable<T>> implements Comparable<Sort<T>> {
	private long time;
	protected T[] array; 	// 排序数组
	private int cmpCount;   // 比较次数
	private int swapCount;  // 交换次数
	private DecimalFormat fmt = new DecimalFormat("#.00");
	
	// 排序方法
	public void sort (T[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		this.array = array;
		long begin = System.currentTimeMillis();
		sort();
		time = System.currentTimeMillis() - begin;
	}
	
	protected abstract void sort();
	
	/*
	 * 返回值等于0，代表 array[i1] == array[i2]
	 * 返回值小于0，代表 array[i1] < array[i2]
	 * 返回值大于0，代表 array[i1] > array[i2]
	 */
	protected int cmp(int i1, int i2) {
		cmpCount++;
		return array[i1].compareTo(array[i2]);
	} 
	
	protected int cmp(T v1, T v2) {
		cmpCount++;
		return v1.compareTo(v2);
	} 
	
	protected int cmpElements(Integer v1, Integer v2) {
		cmpCount++;
		return v1 - v2;
	} 
	
	protected void swap(int i1, int i2) {
		swapCount++;
		T tmp = array[i1];
		array[i1] = array[i2];
		array[i2] = tmp;
	} 
	
	private String numberString(int number) {
		if (number < 10000) return "" + number;
		if (number < 100000000) return fmt.format(number / 10000.0) + "万";
		return fmt.format(number / 100000000.0) + "亿";
	}
	
	@Override
	public int compareTo(Sort<T> o) {
		// TODO Auto-generated method stub
		int result = (int)(time - o.time);
		if (result != 0) { 
			return result;
		}
		result = cmpCount - o.cmpCount;
		if (result != 0) {
			return result;
		}
		return swapCount - o.swapCount;
	}
	
	@Override
	public String toString() { 
		String timeStr = "耗时：" + (time / 1000.0) + "s(" + time + "ms)";
		String compareCountStr = "比较：" + numberString(cmpCount);
		String swapCountStr = "交换：" + numberString(swapCount);
		String stableStr = "稳定性：" + isStable();
		return "【" + getClass().getSimpleName() + "】\n" 
				+ stableStr + " \t"
				+ timeStr + " \t"
				+ compareCountStr + "\t "
				+ swapCountStr + "\n"
				+ "------------------------------------------------------------------";
	}
	
	private boolean isStable() {
		if (this instanceof Radix) return true;
		if (this instanceof Counting) return true;
		if (this instanceof Shell) return false;
		Student[] students = new Student[20];
		for (int i = 0; i < students.length; i++) {
			students[i] = new Student(i * 10, 10);
		}
		sort((T[]) students);
		for (int i = 1; i < students.length; i++) {
			int score = students[i].score;
			int prevScore = students[i - 1].score;
			if (score != prevScore + 10) return false;
		}
		return true;
	}
}
