package com.dp;

public class GamePickFromEnds {
/*
 *  http://www.glassdoor.com/Interview/N-pots-each-with-some-number-of-gold-coins-are-arranged-in-a-line-You-are-playing-a-game-against-another-player-You-tak-QTN_350584.htm 
 */
	class Pair{
		int first;
		int second;
	}
	Pair maxProfit(int[] pot){
		if(pot==null)
			return null;
		Pair[][] move=new Pair[pot.length][pot.length];
		for(int i=0;i<pot.length;i++){
			for(int j=0;j<pot.length;j++){
				move[i][j]=new Pair();
			}
		}
		for(int i=0;i<pot.length;i++){
				move[i][i].first=pot[i];
		}
		
		for(int l=2;l<=pot.length;l++){
			for(int i=0;i<=pot.length-1 && i+l-1<pot.length;i++){
				int j=i+l-1;
				if (pot[i] + move[i + 1][j].second > move[i][j - 1].second + pot[j]) {
					move[i][j].first=pot[i]+move[i+1][j].second;
					move[i][j].second=move[i+1][j].first;
				}else{
					move[i][j].first=pot[j]+move[i][j-1].second;
					move[i][j].second=move[i][j-1].first;
				}
			}
		}
		
		for(int i=0;i<pot.length;i++){
			for(int j=0;j<pot.length;j++){
				System.out.print(move[i][j].first+" "+move[i][j].second+"	");
			}
			System.out.println();
		}
		
		return move[0][pot.length-1];
	}
	public static void main(String[] args) {
		int[] a={3,9,1,2};
		GamePickFromEnds gpfe=new GamePickFromEnds();
		Pair pair=gpfe.maxProfit(a);
		System.out.println(pair.first+"   "+pair.second);
	}
}
