package programmingChallenges.copy;

import java.util.*;

class floyddemo
{
	static final int MAXV = 100;
	static final int MAXDEGREE = 50;
	static final int MAXINT = 100007;
	
	static class adjacency_matrix
	{
		int weight[][] = new int[MAXV+1][MAXV+1];
		int nvertices;
		
		adjacency_matrix()
		{
			nvertices=0;
			for(int i=1;i<=MAXV;i++)
				for(int j=1;j<=MAXV;j++)
					weight[i][j]=MAXINT;
		}
		
		void read_adjacency_matrix(boolean directed)
		{
			int m;
			int x,y,w;
			Scanner sc = new Scanner(System.in);
			nvertices=sc.nextInt();
			m=sc.nextInt();
			for(int i=1;i<=m;i++)
			{
				x=sc.nextInt();
				y=sc.nextInt();
				w=sc.nextInt();
				weight[x][y]=w;
				if(!directed)
					weight[y][x]=w;
			}
		}
		
		void print_graph()
		{
			for (int i=1; i<=nvertices; i++) 
			{
				System.out.printf("%d: ",i);
				for (int j=1; j<=nvertices; j++)
					if (weight[i][j] < MAXINT)
						System.out.printf(" %d",j);
				System.out.printf("\n");
			}
		}
		
		void print_adjacency_matrix()
		{
			for (int i=1; i<=nvertices; i++) 
			{
				System.out.printf("%3d: ",i);
				for (int j=1; j<=nvertices; j++)
					System.out.printf(" %3d",weight[i][j]);
				System.out.printf("\n");
			}
		}
	}
	
	static void floyd(adjacency_matrix g)
	{
		int i,j,k,through_k;
		for (k=1; k<=g.nvertices; k++)
		for (i=1; i<=g.nvertices; i++)
			for (j=1; j<=g.nvertices; j++) {
				through_k = g.weight[i][k]+g.weight[k][j];
				if (through_k < g.weight[i][j])
					g.weight[i][j] = through_k;
			}
	}
	
	static public void main(String[] args)
	{
		adjacency_matrix g = new adjacency_matrix();
		g.read_adjacency_matrix(false);
		g.print_graph();
		floyd(g);
		g.print_adjacency_matrix();
	}
}