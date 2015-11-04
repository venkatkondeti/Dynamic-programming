package com.dp;

public class LongestIncreasingSubsequence {
	
	int lis(int[] a){
		if(a==null)
			return 0;
		int[] t=new int[a.length];
		for(int i=0;i<a.length;i++){
			t[i]=1;
		}
		for(int i=1;i<a.length;i++){
			for(int j=0;j<i;j++){
				if(a[i]>a[j]&&t[j]+1>t[i])
					t[i]=t[j]+1;
			}
		}
		int max=t[0];
		for(int i=1;i<t.length;i++){
			if(max<t[i])
				max=t[i];
		}
		return max;
	}
	public static void main(String[] args) {
		int[] a={2,-1,4,0,1,3};
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		System.out.println(lis.lis(a));
	}
	
}
