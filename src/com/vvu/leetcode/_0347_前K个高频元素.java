package com.vvu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

// https://leetcode.com/problems/top-k-frequent-elements/submissions/
@SuppressWarnings("unchecked")
public class _0347_前K个高频元素 {
	
	// 使用快速排序思想
    public List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) { // O(n)
        	counts.put(num, counts.getOrDefault(num, 0) + 1);
		}
		Entry<Integer, Integer>[] entries = new Entry[counts.size()];
        counts.entrySet().toArray(entries); // O(m)
        
        int begin = 0;
        int end = entries.length;
        int pivotIndex = 0;
        int destIndex = k - 1;
        while ((pivotIndex = pivotIndex(entries, begin, end)) != destIndex) {
			if (pivotIndex > destIndex) {
				end = pivotIndex;
			} else {
				begin = pivotIndex + 1;
			}
		}
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {// O(k)
			result.add(entries[i].getKey());
		}
        return result;
    }
    
    private int pivotIndex(Entry<Integer, Integer>[] entries, int begin, int end) {
		int newBegin = begin + (int)(Math.random() * (end - begin));
		Entry<Integer, Integer> tmp = entries[begin];
		entries[begin] = entries[newBegin];
		entries[newBegin] = tmp;
		Entry<Integer, Integer> pivot = entries[begin];
		end--;
		while (begin < end) {
			while (begin < end) {
				if (pivot.getValue() > entries[end].getValue()) {
					end--;
				} else {
					entries[begin++] = entries[end];
					break;
				}
			}
			while (begin < end) {
				if (pivot.getValue() < entries[begin].getValue()) {
					begin++;
				} else {
					entries[end--] = entries[begin];
					break;
				}
			}
		}
		entries[begin] = pivot;
		return begin;
	}
    
	// 使用桶排序 O(n) 
    public List<Integer> topKFrequent2(int[] nums, int k) {
        // 利用 Map 存储每个整数出现的次数
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) { // O(n)
        	counts.put(num, counts.getOrDefault(num, 0) + 1);
		}
        
    	List<Integer>[] buckets = new List[nums.length + 1];  // O(m)
    	for (Entry<Integer, Integer> entry : counts.entrySet()) { 
			int frequent = entry.getValue();
			List<Integer> bucket = buckets[frequent];
			if (bucket == null) {
				bucket = new LinkedList<>();
				buckets[frequent] = bucket;
			}
			bucket.add(entry.getKey());  
		}
    	
    	List<Integer> result = new ArrayList<>(); // O(n)
    	for (int i = nums.length; i > 0 && result.size() < k; i--) {
			if (buckets[i] == null) {
				continue;
			}
			result.addAll(buckets[i]);
		}
        return result;
    }
    
    
	// 使用优先级队列 优化版本
    public List<Integer> topKFrequent3(int[] nums, int k) {
        // 利用 Map 存储每个整数出现的次数
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) { // O(n)
        	counts.put(num, counts.getOrDefault(num, 0) + 1);
		}
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(
        		(Integer v1, Integer v2) -> {
        			return counts.get(v1) - counts.get(v2);
        });
        
        // O(mlogk)
        for (Entry<Integer, Integer> entry : counts.entrySet()) {
        	if (queue.size() < k) {
				queue.offer(entry.getKey());
			} else if (entry.getValue() >  counts.get(queue.peek())) {
				queue.poll();
				queue.offer(entry.getKey());
			}
		}
        List<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()) {
			result.add(0, queue.poll());
		}
        return result;
    }
    
    
	// 使用优先级队列
    public List<Integer> topKFrequent4(int[] nums, int k) {
        // 利用 Map 存储每个整数出现的次数
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) { // O(n)
        	counts.put(num, counts.getOrDefault(num, 0) + 1);
		}
        
        PriorityQueue<Entry<Integer, Integer>> queue = new PriorityQueue<>(
        		(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) -> {
        			return e1.getValue() - e2.getValue();
        });
        // O(mlogk)
        for (Entry<Integer, Integer> entry : counts.entrySet()) {
        	if (queue.size() < k) {
				queue.offer(entry);
			} else if (entry.getValue() > queue.peek().getValue()) {
				queue.poll();
				queue.offer(entry);
			}
		}
        
        // O(klogk)
        List<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()) {
			Entry<Integer, Integer> entry = queue.poll();
			result.add(0,entry.getKey());
		}
        return result;
    }
    
    
    // 全排序 
    public List<Integer> topKFrequent5(int[] nums, int k) {
        // 利用 Map 存储每个整数出现的次数
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) { // O(n)
//        	Integer count = counts.get(num);
//        	count = count == null ? 0 : count;
        	counts.put(num, counts.getOrDefault(num, 0) + 1);
		}
		Entry<Integer, Integer>[] entries = new Entry[counts.size()];
        counts.entrySet().toArray(entries); // O(m)
        Arrays.sort(entries, (Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) -> {
        	return e2.getValue() - e1.getValue();
        }); // O(mlogm)
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {// O(k)
			result.add(entries[i].getKey());
		}
        return result;
    }
     
    
    public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		new _0347_前K个高频元素().topKFrequent5(nums, 2);
	}
    
}
