package programmingChallenges;
import java.util.*;

class substringedit
{
	static class cell
	{
		int cost, parent;
	}
	static final int MAXLEN = 100;
	static cell m[][] = new cell[MAXLEN][MAXLEN];
	static final int MATCH = 0;
	static final int INSERT = 1;
	static final int DELETE = 2;
	
	static int indel(char c)
	{
		return 1;
	}
	
	static int match(char c, char d)
	{
		if(c==d) return 0;
		return 1;
	}
	
	static void row_init(int i)
	{
		m[0][i].cost = 0;
		m[0][i].parent = -1;
	}
	
	static void column_init(int i)
	{
		m[i][0].cost = i;
		if (i>0) m[i][0].parent = DELETE;
		else m[0][i].parent = -1;
	}
	
	static class pair
	{
		int i,j;
	}
	
	static pair goal_cell(String s, String t)
	{
		pair ret = new pair();
		ret.i = s.length() - 1;
		ret.j = 0;
		for(int k=1;k<t.length();k++)
			if(m[ret.i][k].cost<m[ret.i][ret.j].cost)
				ret.j=k;
		return ret;
	}
	static int string_compare(String s, String t)
	{
		for(int i=0;i<MAXLEN;i++)
		{
			row_init(i);
			column_init(i);
		}
		int k, lowest_cost;
		int opt[] = new int [3];
		for(int i=1;i<s.length();i++)
			for(int j=1;j<t.length();j++)
			{
				opt[MATCH] = m[i-1][j-1].cost + match(s.charAt(i),t.charAt(j));
				opt[INSERT] = m[i][j-1].cost + indel(t.charAt(j));
				opt[DELETE] = m[i-1][j].cost + indel(s.charAt(i));
				m[i][j].cost = opt[MATCH];
				m[i][j].parent = MATCH;
				for (k=INSERT; k<=DELETE; k++)
					if (opt[k] < m[i][j].cost) 
					{
						m[i][j].cost = opt[k];
						m[i][j].parent = k;
					}
			}
		pair tmp = goal_cell(s,t);
		return m[tmp.i][tmp.j].cost;
	}
	
	static void print_matrix(String s, String t, boolean costQ)
	{
		int x = s.length();
		int y = t.length();
		System.out.printf("   ");
		for(int i=0;i<y;i++)
			System.out.printf("  %c",t.charAt(i));
		System.out.printf("\n");
		for(int i=0; i<x; i++) {
			System.out.printf("%c: ",s.charAt(i));
			for(int j=0; j<y; j++) {
				if(costQ)
					System.out.printf(" %2d",m[i][j].cost);
				else
					System.out.printf(" %2d",m[i][j].parent);
				}
			System.out.printf("\n");
		}
	}
	
	static void reconstruct_path(String s, String t, int i, int j)
	{
		if(m[i][j].parent == -1) return;
		if (m[i][j].parent == MATCH) {
			reconstruct_path(s,t,i-1,j-1);
			match_out(s, t, i, j);
			return;
		}
		if (m[i][j].parent == INSERT) {
			reconstruct_path(s,t,i,j-1);
			insert_out(t,j);
			return;
		}
		if (m[i][j].parent == DELETE) {
			reconstruct_path(s,t,i-1,j);
			delete_out(s,i);
			return;
		}
		return;
	}
	
	static void match_out(String s, String t, int i, int j)
	{
		if(s.charAt(i) == t.charAt(j)) System.out.printf("M");
		else System.out.printf("S");
	}
	
	static void insert_out(String t, int j)
	{
		System.out.printf("I");
	}
	
	static void delete_out(String s, int i)
	{
		System.out.printf("D");
	}

	static public void main(String[] args)
	{
		for(int i=0;i<MAXLEN;i++)
			for(int j=0;j<MAXLEN;j++)
				m[i][j]=new cell();
		String s = new String();
		String t = new String();
		Scanner sc = new Scanner(System.in);
		s=sc.next();
		t=sc.next();
		s=" " + s;
		t=" " + t;
		System.out.printf("matching cost = %d \n", string_compare(s,t));
		print_matrix(s,t,true);
		System.out.printf("\n");
		print_matrix(s,t,false);
		int k;
		int i=s.length()-1;
		int j=0;
		for(k=1;k<t.length();k++)
			if(m[i][k].cost<m[i][j].cost)
				j=k;
		System.out.printf("%d %d\n",i,j);
		reconstruct_path(s,t,i,j);
		System.out.printf("\n");
	}
}