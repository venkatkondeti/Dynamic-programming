package com.dp;

public class MaxSumNonAdjacent {
	int maxSum(int[] a){
		if(a==null)
			return 0;
		int inc=a[0];
		int exc=0;
		for(int i=1;i<a.length;i++){
			int temp=inc;
			inc=Math.max(inc, exc+a[i]);
			exc=temp;
		}
		return inc;
	}
	public static void main(String[] args) {
		int[] a={4,1,1,4,2,1};
		MaxSumNonAdjacent ms=new MaxSumNonAdjacent();
		System.out.println(ms.maxSum(a));
	}
}
