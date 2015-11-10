package com.dp;
/**
 * total no of ways to reach bottom right corner from top left. You can 
 * only move right or down. 
 * @author venkat
 *
 */
public class TotalWaysPathProblem {
	int totalWaysPathProblem(int[][] m){
		if(m==null)
			return 0;
		int[][] t=new int[m.length][m[0].length];
		for(int i=0;i<t.length;i++){
			for(int j=0;j<t[0].length;j++){
				if(i==0||j==0)
					t[i][j]=1;
				else
					t[i][j]=t[i-1][j]+t[i][j-1];
			}
		}
		return t[t.length-1][t[0].length-1];
	}
	public static void main(String[] args) {
		int[][] m={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,1,15,16}};
		TotalWaysPathProblem twpp=new TotalWaysPathProblem();
		System.out.println(twpp.totalWaysPathProblem(m));
	}
}
