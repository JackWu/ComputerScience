package programmingChallenges.copy;

import java.util.*;

class elevator
{
	static final int NFLOORS = 25;
	static final int MAX_RIDERS = 50;
	static final int MAXINT = 100007;	
	static int stops[] = new int [MAX_RIDERS];
	static int nriders, nstops;
	static int m[][] = new int [NFLOORS+1][MAX_RIDERS];
	static int p[][] = new int [NFLOORS+1][MAX_RIDERS];
	
	static int optimize_floors()
	{
		int cost,laststop;
		for(int i=0;i<=NFLOORS;i++)
		{
			m[i][0]=floors_walked(0,MAXINT);
			p[i][0]=-1;
		}
		for(int j=1;j<=nstops;j++)
			for(int i=0;i<=NFLOORS;i++)
			{
				m[i][j]=MAXINT;
				for(int k=0;k<=i;k++)
				{
					cost=m[k][j-1]-floors_walked(k,MAXINT)+
					floors_walked(k,i)+floors_walked(i,MAXINT);
					if(cost<m[i][j])
					{
						m[i][j]=cost;
						p[i][j]=k;
					}
				}
			}
		laststop = 0;
		for(int i=1;i<=NFLOORS;i++)
			if(m[i][nstops]<m[laststop][nstops])
				laststop = i;
		return laststop;
	}
	
	static int floors_walked(int previous,int current)
	{
		int nsteps=0;
		for(int i=1;i<=nriders;i++)
			if(stops[i]>previous&&stops[i]<=current)
				nsteps+=Math.min(stops[i]-previous, current-stops[i]);
		return nsteps;
	}
	
	static void reconstruct_path(int lastfloor, int stops_to_go)
	{
		if (stops_to_go > 1)
			reconstruct_path( p[lastfloor][stops_to_go], stops_to_go-1);
		System.out.printf("%d\n",lastfloor);
	}
	
	static void print_matrix(int m[][])
	{
		for (int j=0; j<=nstops; j++)
		{
			for (int i=0; i<=NFLOORS; i++)
				System.out.printf("%3d",m[i][j]);
			System.out.printf("\n");
		}
	}
	
	static public void main(String[] args)
	{
		int laststop;
		Scanner sc = new Scanner(System.in);
		nriders = sc.nextInt();
		nstops = sc.nextInt();
		for (int i=1; i<=nriders; i++)
			stops[i] = sc.nextInt();
		for (int i=1; i<=nriders; i++)
			System.out.printf("%d\n",stops[i]);
		laststop = optimize_floors();
		print_matrix(m);
		System.out.printf("\n");
		print_matrix(p);
		System.out.printf("cost = %d\n",m[laststop][nstops]);
		reconstruct_path(laststop,nstops);
	}
}
