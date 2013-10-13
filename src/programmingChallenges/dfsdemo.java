package programmingChallenges;

class dfsdemo
{
	static final int MAXV = 100;
	static boolean processed[] = new boolean[MAXV];
	static boolean discovered[] = new boolean[MAXV];
	static int parent[] = new int[MAXV];
	static boolean finished = false;
	static int entry_time[] = new int[MAXV];
	static int exit_time[] = new int[MAXV];
	
	static void process_vertex_early(int v)
	{
		timer++;
		entry_time[v] = timer;
		System.out.printf("entered vertex %d at time %d\n",v, entry_time[v]);
	}
	
	static void process_vertex_late(int v)
	{
		timer++;
		exit_time[v] = timer;
		System.out.printf("exit vertex %d at time %d\n",v, exit_time[v]);
	}
	
	static final int TREE = 1;
	static final int BACK = 2;
	static final int FORWARD = 3;
	static final int CROSS = 4;
	static int timer = 0;
	
	static int edge_classification(int x, int y)
	{
		if (parent[y] == x) return(TREE);
		if (discovered[y] && !processed[y]) return(BACK);
		if (processed[y] && (entry_time[y]>entry_time[x])) return(FORWARD);
		if (processed[y] && (entry_time[y]<entry_time[x])) return(CROSS);
		System.out.printf("Warning: self loop (%d,%d)\n",x,y);
		return -1;
	}
	
	static void dfs(graph g, int v)
	{
		int y;
		if(finished) return;
		discovered[v] = true;
		timer++;
		entry_time[v] = timer;
		process_vertex_early(v);
		for(int i=g.degree[v]-1;i>=0;i--)
		{
			y = g.edges[v][i];
			if(!discovered[y])
			{
				parent[y]=v;
				process_edge(v,y);
				dfs(g,y);
			}
			else
			{
				if(!processed[y])
					process_edge(v,y);
			}
			if(finished) return;
		}
		process_vertex_late(v);
		timer++;
		exit_time[v]=timer;
		processed[v]=true;
	}
	
	static void process_edge(int x,int y)
	{
		int c = edge_classification(x,y);
		if (c == BACK) System.out.printf("back edge (%d,%d)\n",x,y);
		else if (c == TREE) System.out.printf("tree edge (%d,%d)\n",x,y);
		else if (c == FORWARD) System.out.printf("forward edge (%d,%d)\n",x,y);
		else if (c == CROSS) System.out.printf("cross edge (%d,%d)\n",x,y);
		else System.out.printf("edge (%d,%d)\n not in valid class=%d",x,y,c);
	}
	
	static void process_vertex(int v)
	{
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
	
	static void initialize_search(graph g)
	{
		for(int i=1;i<=g.nvertices;i++)
		{
			processed[i] = discovered[i] = false;
			parent[i] = -1;
		}
	}
	
	static public void main(String[] args)
	{
		graph g = new graph();
		g.read_graph(false);
		g.print_graph();
		initialize_search(g);
		dfs(g,1);
		for(int i=1;i<=g.nvertices;i++)
			find_path(1,i,parent);
		System.out.printf("\n");
	}
}