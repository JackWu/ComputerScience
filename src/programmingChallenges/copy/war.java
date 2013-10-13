package programmingChallenges.copy;

/*
 * Going to War
 * Section 2.3
 * By Derek Hao Hu (derekhh@cse.ust.hk)
 */

import java.io.*;

public class war
{
	public static final int NCARDS = 52;
	public static final int NSUITS = 4;
	public static final int MAXSTEPS = 100000;
	
	public static char values[] = new char[]{'2','3','4','5','6','7','8','9','T','J','Q','K','A'};
	public static char suits[] = new char[]{'c','d','h','s'};
	
	static int rank_card(char value, char suit)
	{
		int i,j;
		for(i=0; i<(NCARDS/NSUITS); i++)
			if(values[i] == value)
				for(j=0; j<NSUITS; j++)
					if(suits[j] == suit)
						return (i * NSUITS + j);
		System.out.printf("Warning: bad input value=%d, suit=%d\n",(int)value,(int)suit);
		return -1;
	}
	
	static char suit(int card)
	{
		return (suits[card%NSUITS]);
	}
	
	static char value(int card)
	{
		return (values[card/NSUITS]);
	}
	
	static void clear_queue(queue a, queue b)
	{
		while(!a.empty())
			b.enqueue(a.dequeue());
	}
	
	static void war(queue a, queue b)
	{
		int steps=0,x,y;
		queue c = new queue();
		boolean inwar=false;
		while(!a.empty()&&!b.empty()&&steps<MAXSTEPS)
		{
			steps++;
			x = a.dequeue();
			y = b.dequeue();
			c.enqueue(x);
			c.enqueue(y);
			if(inwar)
				inwar = false;
			else
			{
				if(value(x) > value(y))
					clear_queue(c,a);
				else if(value(x) < value(y))
					clear_queue(c,b);
				else if(value(x)==value(y))
					inwar = true;
			}
		}
		if(!a.empty()&&b.empty())
			System.out.printf("a wins in %d steps \n",steps);
		else if(a.empty()&&!b.empty())
			System.out.printf("b wins in %d steps \n",steps);
		else if(!a.empty()&&!b.empty())
			System.out.printf("game tied after %d steps, |a|=%d |b|=%d \n",steps,a.count,b.count);
		else
			System.out.printf("a and b tie in %d steps\n",steps);
	}
	
	public static void main(String[] args)
	{
		queue decks[] = new queue[2];
		char value, suit, c;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			for(int i=0;i<=1;i++)
			{
				decks[i] = new queue();
				try
				{
					while((c = (char)in.read()) != '\n')
					{
						if(!in.ready()) return;
						if(c != ' ')
						{
							value = c;
							suit = (char)in.read();
							decks[i].enqueue(rank_card(value,suit));
						}
					}
				}
				catch(IOException e)
				{
					System.out.printf("IO Exception Error!\n");
				}
			}
			war(decks[0],decks[1]);
		}
	}
}