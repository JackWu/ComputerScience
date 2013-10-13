package programmingChallenges.copy;
import java.util.Scanner;

public class gcd_test 
{
	static long gcd1(long p, long q)
	{
		if(q > p)
			return gcd1(q,p);
		if(q == 0)
			return p;
		System.out.printf(" gcd(%d,%d) &=& gcd(%d \\mod %d, %d) = gcd(%d,%d) \n",p,q,p,q,q,q,p%q);
		return gcd1(q,p%q);
	}
	
	static public class result
	{
		long res, x, y;
	}
	
	static result gcd(long p, long q)
	{
		result ret = new result();
		if(q > p)
		{
			result r = gcd(q,p);
			ret.res = r.res;
			ret.x = r.y;
			ret.y = r.x;
			return ret;
		}
		if(q == 0)
		{
			ret.x = 1;
			ret.y = 0;
			ret.res = p;
			return ret;
		}
		result r = gcd(q,p%q);
		
		ret.res = r.res;
		ret.x = r.y;
		ret.y = r.x - (long)Math.floor(p/q) * r.y;
		
		return ret;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		long p,q;
		while(sc.hasNextLong())
		{
			p = sc.nextLong();
			q = sc.nextLong();
			long g;
			System.out.printf("gcd of p=%d and q=%d = %d\n",p,q,g=gcd1(p,q));
			System.out.printf(" %d*%d + %d*%d = %d\n",p,gcd(p,q).x,q,gcd(p,q).y,gcd(p,q).res);
			
			if(g != gcd(p,q).res)
				System.out.printf("ERROR!\n");
			
			if(p * gcd(p,q).x + q * gcd(p,q).y != g)
				System.out.printf("ERROR: DIOPHONINE SOLUTION WRONG!\n");
		}
	}
}
