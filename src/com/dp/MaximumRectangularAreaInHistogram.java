package com.dp;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumRectangularAreaInHistogram {
	
	int maxArea(int[] a){
		if(a==null)
			return 0;
		int maxArea=0;
		int area=0;
		int i;
		Deque<Integer> stack=new LinkedList<Integer>();
		for( i=0;i<a.length;){
			if(stack.isEmpty()||a[stack.peekFirst()]<=a[i])
				stack.offerFirst(i++);
			else{
				int top=stack.pollFirst();
				if(stack.isEmpty()){
					area=a[top]*i;
				}else{
					area=a[top]*(i-stack.peekFirst()-1);
				}
				if(area>maxArea)
					maxArea=area;
			}
		}
		while(!stack.isEmpty()){
			int top=stack.pollFirst();
			if(stack.isEmpty()){
				area=a[top]*i;
			}else{
				area=a[top]*(i-stack.peekFirst()-1);
			}
			if(area>maxArea)
				maxArea=area;
		}
		return maxArea;
	}
	public static void main(String[] args) {
		int[]a={2,1,2};
		MaximumRectangularAreaInHistogram mrah=new MaximumRectangularAreaInHistogram();
		System.out.println(mrah.maxArea(a));
	}
}
