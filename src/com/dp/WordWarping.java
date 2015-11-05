package com.dp;

import java.util.HashSet;
import java.util.Set;

public class WordWarping {

	String wordWrap(String word,Set dist){
		if(word==null)
			return null;
		
		int[][] t=new int[word.length()][word.length()];
		
		for(int i=0;i<t.length;i++){
			for(int j=0;j<t[0].length;j++){
				t[i][j]=-1;
			}
		}
		
		for(int l=1;l<=word.length();l++){
			for(int i=0;i<word.length()-l+1;i++){
				int j=i+l-1;
				String str=word.substring(i,j+1);
				if(dist.contains(str)){
					t[i][j]=i;
					continue;
				}
				for(int k=i+1;k<=j;k++){
					if(t[i][k-1]!=-1 && t[k][j]!=-1){
						t[i][j]=k;
						break;
					}
				}				
			}
		}
		
		for(int i=0;i<t.length;i++){
			for(int j=0;j<t[0].length;j++){
				System.out.print(" "+t[i][j]);
			}
			System.out.println();
		}
		
		if(t[0][word.length()-1] == -1){
            return null;
        }
		StringBuffer sb=new StringBuffer();
		int i=0,j=word.length()-1;
		while(i<j){
			int k=t[i][j];
			if(i==k){
				sb.append(word.substring(k));
				break;
			}
			sb.append(word.substring(i,k)+" ");
			i=k;
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		Set set=new HashSet<String>();
		set.add("i");
		set.add("am");
		//set.add("a");
		set.add("freak");
		WordWarping warping=new WordWarping();
		System.out.println(warping.wordWrap("iam", set)); 
	}
}
