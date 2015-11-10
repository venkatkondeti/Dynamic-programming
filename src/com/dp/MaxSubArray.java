package com.dp;
public class MaxSubArray {
	Result maxSubArray(int[] a){
		if(a==null)
			return null;
		Result max_cur=new Result();
		Result max=new Result();
		Result[] res=new Result[a.length];
		max_cur.sum=max.sum=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++){
			if(max_cur.sum<0){
				max_cur.sum=a[i];
				max_cur.i=i;
				max_cur.j=i;
				
			}else{
				max_cur.sum+=a[i];
				max_cur.j=i;
			}
			if(max_cur.sum>max.sum){
				max.sum=max_cur.sum;
				max.i=max_cur.i;
				max.j=max_cur.j;
			}
			
			Result t=new Result();
			t.sum=max.sum;
			t.i=max.i;
			t.j=max.j;
			res[i]=t;
		}
		/*for(int i=0;i<a.length;i++){
			System.out.println("sum: "+res[i].sum+" i: "+res[i].i+"j: "+res[i].j);
		}*/
		return res[a.length-1];
	}
	public static void main(String[] args) {
		MaxSubArray msa=new MaxSubArray();
		int[] a={-2,-1,3,4,-5,6};
		Result max=msa.maxSubArray(a);
		System.out.println("sum: "+max.sum+" i: "+max.i+"j: "+max.j);
	}	
}
class Result{
	int i;
	int j;
	int sum;
}
