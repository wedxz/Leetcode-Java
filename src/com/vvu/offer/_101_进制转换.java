package com.vvu.offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@SuppressWarnings("rawtypes")
public class _101_进制转换 {
    
    public static void main(String[] args) {
        convert(1, 2);
        convert(2, 2);
        convert(3, 2);
        
        convert(7, 8);
        convert(8, 8);
        convert(10, 8);
        
        convert(15, 16);
        convert(16, 16);
        convert(17, 16);
    }
    
    public static void convert(int M, int N) {
		if (N == 10) {
			System.out.println(M);
			return;
		}
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(10, "A");
		map.put(11, "B");
		map.put(12, "C");
		map.put(13, "D");
		map.put(14, "E");
		map.put(15, "F");

		Stack list = new Stack();
		
		// 
		while (M > 0) {
			int num = M % N;
			if (N <  10) {
				list.push(num);
			} else {
				list.push(num > 9 ? map.get(num) : num);
			}
			 M /= N;
		}
		
		while (!list.isEmpty()) {
			 System.out.print(list.pop());
		}
		
		 System.out.println("");
    }
}
