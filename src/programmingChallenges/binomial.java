package programmingChallenges;

import java.util.Scanner;

/*
 * Binomial.java
 * Compute the binomial coefficients using dynamic programming
 * Chapter 6.3
 * 
 * By Derek Hao Hu (derekhh@cse.ust.hk)
 */

public class binomial 
{
	static final int MAXN = 100;		/* largest n or m */
	static long binomial_coefficient(int n, int m)
	{
		int i, j;
		long bc[][] = new long [MAXN][MAXN];
		for(i=0;i<=n;i++) bc[i][0] = 1;
		for(j=0;j<=n;j++) bc[j][j] = 1;
		for(i=1;i<=n;i++)
			for(j=1;j<=i;j++)
				bc[i][j]=bc[i-1][j-1]+bc[i-1][j];
		return bc[n][m];
	}
	public static void main(String[] args)
	{
		int a,b;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt())
		{
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.printf("%d\n", binomial_coefficient(a,b));
		}
	}
}
