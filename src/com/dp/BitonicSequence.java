package com.dp;

public class BitonicSequence {
	int longestBitonicSequence(int[] a){
		if(a==null)
			return 0;
		int[] lis=new int[a.length];
		int[] lds=new int[a.length];
		
		for(int i=0;i<a.length;i++){
			lis[i]=1;
			lds[i]=1;
		}
		for(int i=1;i<lis.length;i++){
			for(int j=0;j<i;j++){
				if(a[i]>a[j]&&lis[i]<lis[j]+1)
					lis[i]=lis[j]+1;
			}
		}
		for(int i=a.length-2;i>=0;i--){
			for(int j=a.length-1;i<j;j--){
				if(a[i]>a[j]&&lds[i]<lds[j]+1)
					lds[i]=lds[j]+1;
			}
		}
		int max=lis[0]+lds[0]+1;
		for(int i=1;i<a.length;i++){
			if(lis[i]+lds[i]-1>max)
				max=lis[i]+lds[i]-1;
		}
		return max;
	}
	public static void main(String[] args) {
		BitonicSequence bs=new BitonicSequence();
		int a[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		System.out.println(bs.longestBitonicSequence(a));
	}
}
