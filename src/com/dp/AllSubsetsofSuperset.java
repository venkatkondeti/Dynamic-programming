package com.kondeti.hackerearth;

import java.util.ArrayList;

public class PandaXorMAXOR {

	public static void subsets(int[] superSet) {
		if (superSet.length == 0 || superSet == null)
			return;
		int setSize = superSet.length;
		int numberOfSubsets = (int) Math.pow(2, setSize);
		int temp = numberOfSubsets;
		ArrayList<ArrayList<Integer>> subList = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<numberOfSubsets;i++){
			ArrayList<Integer> list = new ArrayList<Integer>();
			int temp1=temp;
			for(int j=0;j<superSet.length;j++){
				if((temp1&1)==1)
					list.add(superSet[j]);
				temp1>>=1;
			}
			subList.add(list);
			temp--;
		}
		
		
		for(ArrayList<Integer> list : subList){
			/*for(Integer integer : list){
				
			}*/
			System.out.println(list);
		}
	}

	public static void main(String[] args) {
		int[] array={1,2,3,4};
		PandaXorMAXOR.subsets(array);
	}
}
