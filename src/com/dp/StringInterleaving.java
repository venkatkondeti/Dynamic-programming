package com.dp;

public class StringInterleaving {
	boolean isInterleaving(char[] str1,char[] str2,char[] interleavingString){
		if(str1.length + str2.length != interleavingString.length){ 
			return false; 
         } 

		boolean[][] t=new boolean[str1.length+1][str2.length+1];
		t[0][0]=true;
		for(int i=1;i<t[0].length;i++)
			if(str2[i-1]==interleavingString[i-1])
				t[0][i]=t[0][i-1];
		for(int i=1;i<t.length;i++)
			if(str1[i-1]==interleavingString[i-1])
				t[i][0]=t[i-1][0];
		
		for(int i=1;i<t.length;i++){
			for(int j=1;j<t[0].length;j++){
				if(interleavingString[i+j-1]==str1[i-1]&&interleavingString[i+j-1]==str2[i-1]){
					if(t[i-1][j]||t[i][j-1]){
						t[i][j]=true;
						continue;
					}
				}
				if(interleavingString[i+j-1]==str2[j-1]){
					t[i][j]=t[i][j-1];
						continue;
				}
				if(interleavingString[i+j-1]==str1[i-1]){
					t[i][j]=t[i-1][j];
						continue;
				}
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
		char[] str2={'a','a','b'};
		char[] str1={'a','x','y'};
		char[] interleaving={'a','a','x','a','b','y'};
		StringInterleaving si=new StringInterleaving();
		System.out.println(si.isInterleaving(str1, str2, interleaving));
	}
}
