package programmingChallenges.copy;
import java.util.*;

class order
{
	static void row_major(int n, int m)
	{
		for(int i=1;i<=n;i++)
			for(int j=1;j<=m;j++)
				proc(i,j);
	}
	
	static void column_major(int n, int m)
	{
		for(int j=1; j<=m; j++)
			for(int i=1; i<=n; i++)
				proc(i,j);
	}
	
	static void snake_order(int n, int m)
	{
		for(int i=1; i<=n; i++)
			for(int j=1; j<=m; j++)
				proc(i,j+(m+1-2*j)*((i+1)%2));
	}
	
	static void diagonal_order(int n,int m)
	{
		int pcount,height;
		for(int d=1;d<=(m+n-1);d++)
		{
			height = 1 + Math.max(0,d-m);
			pcount = Math.min(d, (n-height+1));
			for(int j=0; j<pcount; j++)
				proc(Math.min(m,d)-j, height+j);
		}
	}
	
	static void proc(int i, int j)
	{
		System.out.printf("(%d,%d)\n",i,j);
	}
	
	static public void main(String[] args)
	{
		System.out.printf("row_major\n");
		row_major(5,5);
		System.out.printf("\ncolumn_major\n");
		column_major(3,3);
		System.out.printf("\nsnake_order\n");
		snake_order(5,5);
		System.out.printf("\ndiagonal_order\n");
		diagonal_order(3,4);
		System.out.printf("\ndiagonal_order\n");
		diagonal_order(4,3);
	}
}