package com.dp;

public class EditDistance {
	
	int editDistance(char[] n,char[] m){
		
		int[][] t=new int[n.length+1][m.length+1];
		
		for(int i=1;i<n.length+1;i++){
			t[i][0]=i;
		}
		for(int i=1;i<m.length+1;i++){
			t[0][i]=i;
		}
		
		for(int i=1;i<n.length+1;i++){
			for(int j=1;j<m.length+1;j++){
				if(n[i-1]==m[j-1])
					t[i][j]=t[i-1][j-1];
				else
					t[i][j]=Math.min(t[i-1][j], Math.min(t[i][j-1],t[i-1][j-1]))+1;
			}
		}
		
		for(int i=0;i<n.length+1;i++){
			for(int j=0;j<m.length+1;j++){
				System.out.print(" "+t[i][j]);
			}
			System.out.println();
		}
		return t[n.length][m.length];
	}
	public static void main(String[] args) {
		char[] n={'s','u','n','d','a','y'};
		char[] m={'s','a','t','u','r','d','a','y'};
		EditDistance ed=new EditDistance();
		System.out.println(ed.editDistance(n,m));
	}
}
