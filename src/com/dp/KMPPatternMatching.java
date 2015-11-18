package com.dp;

public class KMPPatternMatching {
	private int[] tempArray(char[] pattern){
		int[] t=new int[pattern.length];
		int j=0;
		for(int i=1;i<pattern.length;){
			if(pattern[i]==pattern[j]){
				t[i]=j+1;
				i++;
				j++;
			}else{
				if(j!=0){
					j=t[j-1];
				}else{
					i++;
				}
			}
		}
		return t;
	}
	public boolean isSubStringKMP(char[] text,char[] pattern){
		int[] t=tempArray(pattern);
		int i=0;
		int j=0;
		while(i<text.length && j<pattern.length){
			if(text[i]==pattern[j]){
				i++;
				j++;
			}else{
				if(j!=0){
					j=t[j-1];
				}else{
					i++;
				}
			}
		}
		if(j==pattern.length)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		String text="abxabcabcaby";
		String pattern="abcaby";
		KMPPatternMatching kmp=new KMPPatternMatching();
		System.out.println(kmp.isSubStringKMP(text.toCharArray(), pattern.toCharArray()));
	}
}
