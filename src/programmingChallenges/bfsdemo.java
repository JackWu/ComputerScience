package programmingChallenges;

class bfsdemo
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
				if(valid_edge(g.edges[v][i]))
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
	}
	
	static boolean valid_edge(int v)
	{
		return true;
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
	
	static void process_edge(graph g, int x,int y)
	{
		System.out.printf("processed edge (%d,%d)\n",x,y);
		g.nedges = g.nedges + 1;
	}
	
	static void find_path(int start, int end, int parents[])
	{
		if(start==end || end == -1)
			System.out.printf("\n%d",start);
		else
		{
			find_path(start, parents[end], parents);
			System.out.printf(" %d", end);
		}
	}
	
	static public void main(String[] args)
	{
		graph g = new graph();
		g.read_graph(false);
		g.print_graph();
		initialize_search(g);
		bfs(g,1);
		for(int i=1;i<=g.nvertices;i++)
			System.out.printf(" %d",parent[i]);
		System.out.printf("\n");
		for(int i=1;i<=g.nvertices;i++)
			find_path(1,i,parent);
		System.out.printf("\n");
	}
}