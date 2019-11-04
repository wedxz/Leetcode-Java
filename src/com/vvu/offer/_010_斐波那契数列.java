package com.vvu.offer;

// https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
// 求斐波那契数列的第 n 项，n <= 39
public class _010_斐波那契数列 {
    
	int Fibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		int v1 = 0;
		int v2 = 1;
		int fib = 0;
		for (int i = 2; i <= n; i++) {
			fib = v1 + v2;
			v1 = v2;
			v2 = fib;
		}
		return fib;
    }
}
