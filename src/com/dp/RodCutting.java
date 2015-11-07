package com.dp;

public class RodCutting {
	int maxProfit(int[] p){
		if(p==null)
			return 0;
		int[][] t=new int[p.length+1][p.length+1];
		for(int i=0;i<p.length+1;i++){
			for(int j=0;j<p.length+1;j++){
				if(i==0||j==0)
					continue;
				else if(i<=j)
					t[i][j]=Math.max(t[i-1][j], t[i][j-i]+p[i-1]);
				else
					t[i][j]=t[i-1][j];
			}
		}
		return t[p.length][p.length];
	}
	public static void main(String[] args) {
		RodCutting rc=new RodCutting();
		int[] p={1,5,8,9,10,17,17,20};
		System.out.println(rc.maxProfit(p));
	}
}
