package com.vvu.sort;

import java.util.Arrays;
import com.vvu.tools.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Main {
	public static void main(String[] args) {
//		Integer[] array = {7, 3, 5, 8, 6, 7, 4, 5};
		Integer[] array = Integers.tailAscOrder(1, 10000, 2000);
		testSorts(array, 
				new Radix(),
				new Counting(),
				new Bubble1(),
				new Bubble2(),
				new Bubble3(),
				new Insertion1(),
				new Insertion2(),
				new Insertion3(),
				new Selection(),
				new Heap(),
				new Merge(),
				new Shell(),
				new Quick()
				);
	}

	
	static void testSorts(Integer[] array, Sort... sorts) {
		for (Sort sort : sorts) {
			Integer[] newArray = Integers.copy(array);
			sort.sort(newArray);
			Asserts.test(Integers.isAscOrder(newArray));
		}
		Arrays.sort(sorts);
		
		for (Sort sort : sorts) {
			System.out.println(sort);
		}
	}
	
}