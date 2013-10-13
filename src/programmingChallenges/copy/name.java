package programmingChallenges.copy;
import java.util.*;
import java.io.*;
import java.lang.*;

public class name
{
	static final int MAXLEN = 1001;
	static final int MAXCHANGES = 101; 
	
	static String mergers[][] = new String[MAXCHANGES][2];
	static int nmergers;
	
	static BufferedReader in;
	
	static String read_quoted_string()
	{
		char c;
		String s = new String();
		StringBuffer sb = new StringBuffer();
		try
		{
			while(true)
			{
				c = (char)(in.read());
				if(c == '\"') break;
			}
			while(true)
			{
				c = (char)(in.read());
				if(c == '\"') break;
				sb.append(c);
			}
			s = sb.toString();
		}
		catch(IOException e)
		{
			System.out.printf("IOException Error!\n");
		}
		return s;
	}
	
	static void read_changes()
	{
		in = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			nmergers = Integer.parseInt(in.readLine());
		}
		catch(IOException e)
		{
			System.out.printf("IO Exception Error\n");
		}
		for(int i = 0; i < nmergers; i++)
		{
			mergers[i][0] = read_quoted_string();
			mergers[i][1] = read_quoted_string();
		}
	}
	
	public static void main(String[] args)
	{
		char c;
		int nlines, i, j, pos;
		read_changes();
		try
		{
			while(true)
			{
				c = (char)(in.read());
				if(c == '\n') break;
			}
			nlines = Integer.parseInt(in.readLine());
			for(i = 1; i <= nlines; i++)
    	{
    		String s = new String();
    		StringBuffer sb = new StringBuffer();
  			j = 0;
  			try
  			{
  				while(true)
  				{
  					c = (char)(in.read());
  					if(c == '\n') break;
  					sb.append(c);
  					j = j + 1;
  				}
  				s = sb.toString();
  			}
  			catch(IOException e)
  			{
  				System.out.printf("IO Exception!\n");
  			}
  			
  			for(j = 0; j < nmergers; j++)
  			{
  				s = s.replaceAll(mergers[j][0],mergers[j][1]);
  			}
  			
  			System.out.println(s);
  		}
		}
		catch(IOException e)
		{
			System.out.printf("IO Exception Error\n");
		}
	}
}