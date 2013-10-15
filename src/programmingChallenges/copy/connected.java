package programmingChallenges.copy;

class connected
{
	static final int MAXV = 100;
	static boolean processed[] = new boolean[MAXV];
	static boolean discovered[] = new boolean[MAXV];
	static int parent[] = new int[MAXV];

	static void bfs(graph g,int start)
	{
		queue q = new queue();
		int i,v;
		q.enqueue(start);
		discovered[start]=true;
		while(!q.empty())
		{
			v=q.dequeue();
			process_vertex(v);
			processed[v]=true;
			for(i=g.degree[v]-1;i>=0;i--)
			{
				if(!discovered[g.edges[v][i]])
				{
					q.enqueue(g.edges[v][i]);
					discovered[g.edges[v][i]]=true;
					parent[g.edges[v][i]]=v;
				}
			}
		}
	}
	
	static void initialize_search(graph g)
	{
		for(int i=1;i<=g.nvertices;i++)
		{
			processed[i] = discovered[i] = false;
			parent[i] = -1;
		}
	}
	
	static void process_vertex(int v)
	{
		System.out.printf(" %d",v);
	}
	
	static void connected_components(graph g)
	{
		int c;
		initialize_search(g);
		c = 0;
		for(int i=1;i<=g.nvertices;i++)
		{
			if(!discovered[i])
			{
				c++;
				System.out.printf("Component %d:",c);
				bfs(g,i);
				System.out.printf("\n");
			}
		}
	}
	static public void main(String[] args)
	{
		graph g = new graph();
		g.read_graph(false);
		g.print_graph();
		connected_components(g);
	}
}