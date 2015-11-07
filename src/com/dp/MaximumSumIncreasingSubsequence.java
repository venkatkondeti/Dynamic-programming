package com.dp;

public class MaximumSumIncreasingSubsequence {
	int maximumSumIncreasingSubsequence(int[] a) {
		if (a == null)
			return 0;
		int[] msis = new int[a.length];
		for (int i = 0; i < a.length; i++)
			msis[i] = a[i];
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && msis[i] < a[i] + msis[j])
					msis[i] = a[i] + msis[j];
			}
		}
		int max = msis[0];
		for (int i = 1; i < a.length; i++)
			if (max < msis[i])
				max = msis[i];
		return max;
	}

	public static void main(String[] args) {
		MaximumSumIncreasingSubsequence msis = new MaximumSumIncreasingSubsequence();
		int a[] = { 1, 101, 2, 3, 100, 4, 5 };
		System.out.println(msis.maximumSumIncreasingSubsequence(a));
	}
}
