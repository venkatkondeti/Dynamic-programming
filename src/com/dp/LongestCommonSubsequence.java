package com.dp;

public class LongestCommonSubsequence {
	
	int lcs(char[] n,char[] m){
		int[][] t=new int[n.length+1][m.length+1];
		for(int i=0;i<n.length+1;i++){
			for(int j=0;j<m.length+1;j++){
				if(i==0 || j==0)
					t[i][j]=0;
				else if(n[i-1]==m[j-1])
					t[i][j]=t[i-1][j-1]+1;
				else
					t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
			}
		}
		
		for(int i=0;i<n.length+1;i++){
			for(int j=0;j<m.length+1;j++){
				System.out.print(" "+t[i][j]);
			}
			System.out.println();
		}
		return t[n.length][m.length];
	}
	public static void main(String[] args) {
		char[] n={'a','b','c','d','e','f'};
		char[] m={'a','c','b','e'};
		LongestCommonSubsequence lcs=new LongestCommonSubsequence();
		System.out.println(lcs.lcs(n,m));
	}
	
}
