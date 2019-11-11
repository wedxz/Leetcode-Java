package com.vvu.offer;

import java.util.HashMap;
import java.util.Map;

// https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=13&tqId=11193&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
// 一个整型数组里除了两个数字之外，其他的数字都出现了两次，找出这两个数。
public class _056_数组中只出现一次的数字 {

	//
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
	    int diff = 0;
	    for (int num : array) {
	    	diff ^= num;
	    }
	    diff &= -diff;
	    for (int num : array) {
	        if ((num & diff) == 0) {
	            num1[0] ^= num;
	        } else {
	            num2[0] ^= num;
	        }
	    }
	}
	
	// 使用Map 存储状态值
    public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : array) {
        	if (map.containsKey(num)) {
        	 	map.put(num, 1);
			} else {
				map.put(num, 0);
			}
        }
        num1[0] = -1;
        num2[0] = -1;
        
        for (int num : array) {
			if (map.get(num) == 0) {
				if (num1[0] == -1) {
					num1[0] = num;
				} else if (num2[0] == -1) {
					num2[0] = num;
				}
			}
        }
    }
}
