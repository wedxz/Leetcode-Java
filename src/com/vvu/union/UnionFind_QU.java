package com.vvu.union;

public class UnionFind_QU extends UnionFind {

	public UnionFind_QU(int capacity) {
		super(capacity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int find(int v) {	
		rangeCheck(v);
		return parents[v];
	}

	@Override
	public void union(int v1, int v2) {
		int p1 = parents[v1];
		int p2 = parents[v2];
		if (p1 == p2) return;
		parents[p1] = p2;
	}

}
