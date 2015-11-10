package com.dp;
public class MaximumSumSubMatrix {
	int maxSumSubMatrix(int[][] a){
		MaxSubArray msa=new MaxSubArray();
		int currentSum;
		int maxSum=Integer.MIN_VALUE;
		int maxLeft = 0;
		int maxRight = 0;
		int maxUp = 0;
		int maxDown = 0;

		int[] T=new int[a.length];

		for(int L=0;L<a[0].length;L++){
			for(int t=0;t<a.length;t++){
				T[t]=0;
			}
			for(int R=L;R<a[0].length;R++){
				for(int t=0;t<a.length;t++){
					T[t]+=a[t][R];
				}
				Result res=msa.maxSubArray(T);
				currentSum=res.sum;
				if(currentSum>maxSum){
					maxSum=currentSum;
					maxLeft=L;
					maxRight=R;
					maxUp=res.i;
					maxDown=res.j;
				}
			}
			
		}
		System.out.println(" L: "+maxLeft+" R: "+maxRight+" up "+maxUp+" down "+maxDown);
		return maxSum;
	}
	public static void main(String[] args) {
		int a[][] = {{ 2,  1, -3, -4,  5},
                { 0,  6,  3,  4,  1},
                { 2, -2, -1,  4, -5},
                {-3,  3,  1,  0,  3}};
		MaximumSumSubMatrix mssm=new MaximumSumSubMatrix();
		System.out.println(mssm.maxSumSubMatrix(a));
	}
}
