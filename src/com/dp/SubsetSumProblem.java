package com.dp;

public class SubsetSumProblem {
	boolean isSubsetSumPossible(int[] a,int sum){
		if(sum==0)
			return true;
		if(a==null)
			return false;
		boolean[][] t=new boolean[a.length+1][sum+1];
		for(int i=0;i<t.length;i++){
			t[i][0]=true;
		}
		for(int i=1;i<t.length;i++){
			for(int j=1;j<t[0].length;j++){
				if(a[i-1]<=j)
					t[i][j]=(t[i-1][j]||t[i-1][j-a[i-1]]);
				else
					t[i][j]=t[i-1][j];
			}
		}
		for(int i=0;i<t.length;i++){
			for(int j=0;j<t[0].length;j++){
				System.out.print("	"+t[i][j]);
			}
			System.out.println();
		}
		
		return t[t.length-1][t[0].length-1];
	}
	public static void main(String[] args) {
		int[] a={1,3,5,8};
		SubsetSumProblem ssp=new SubsetSumProblem();
		System.out.println(ssp.isSubsetSumPossible(a, 7));
	}
}
