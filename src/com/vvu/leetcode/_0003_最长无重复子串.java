package com.vvu.leetcode;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class _0003_最长无重复子串 {
	
    public int lengthOfLongestSubstring(String s) {
    	if (s.length() == 0) {
			return 0;
		}
    	int max = 0;
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	for (int i = 0, j = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i-j+1);
		}
    	return max;
    }
    
    // int[256]
    public int lengthOfLongestSubstring2(String s) {
    	int[] m = new int[256];
    	Arrays.fill(m, -1);
    	int res = 0, tmp = -1;
    	for (int i = 0; i < s.length(); i++) {
    		tmp = Math.max(tmp, m[s.charAt(i)]);
			m[s.charAt(i)] = i;
			res = Math.max(res, i - tmp);
		}
    	return res;
    }
}
