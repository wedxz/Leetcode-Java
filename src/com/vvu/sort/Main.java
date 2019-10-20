package com.vvu.sort;

import java.util.Arrays;
import com.vvu.tools.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Main {
	public static void main(String[] args) {
//		Integer[] array = {7, 3, 5, 8, 6, 7, 4, 5};
		Integer[] array = Integers.tailAscOrder(1, 10000, 2000);
		testSorts(array, 
				new Insertion(),
				new Bubble(),
				new Selection(),
				new Heap()
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