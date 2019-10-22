package com.vvu.sort;

import java.util.LinkedList;
import java.util.List;

// 桶排序
@SuppressWarnings("unchecked")
public class Bucket extends Sort<Integer>  {

	@Override
	protected void sort() {
		double[] array = {0.34,0.47,0.29,0.84,0.45,0.38,0.35,0.76};

		List<Double>[] buckets = new List[array.length];
		for (int i = 0; i < buckets.length; i++) {
			int bucketIndex = (int)(array[i] * array.length);
			List<Double> bucket = buckets[bucketIndex];
			if (bucket == null) {
				bucket = new LinkedList<>();
				buckets[bucketIndex] = bucket;
			}
			bucket.add(array[i]);
		}
		
		// 对每一个桶进行排序
		int index = 0;
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] == null) {
				continue;
			}
			buckets[i].sort(null);
			for (Double d: buckets[i]) {
				array[index++] = d;
			}
		}
	}

}
