package programmingChallenges;

import java.util.*;

class convexhull
{
	static final double EPSILON	= 0.000001;
	static final int MAXPOLY = 200;
	static Point first_point = new Point();
	static class Point 
	{
		double x,y;
	}
	static class Polygon
	{
		Point p[] = new Point[MAXPOLY];
		int n;
		Polygon()
		{
			for(int i=0;i<MAXPOLY;i++)
				p[i] = new Point();
		}
	}
	static Point in[] = new Point[MAXPOLY];
	
	static double signed_triangle_area(Point a, Point b, Point c)
	{
		return ((a.x*b.y-a.y*b.x+a.y*c.x-a.x*c.y+b.x*c.y-c.x*b.y)/2.0);
	}

	static boolean cw(Point a, Point b, Point c)
	{
		return signed_triangle_area(a,b,c) < -EPSILON;
	}
	
	static boolean ccw(Point a, Point b, Point c)
	{
		return signed_triangle_area(a,b,c) > EPSILON;
	}
	
	static boolean collinear(Point a, Point b, Point c)
	{
		return Math.abs(signed_triangle_area(a,b,c)) <= EPSILON;
	}
	
	static double distance(Point a, Point b)
	{
		int i;
		double d = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
		return Math.sqrt(d);
	}
	
	static Point copy_point(Point p)
	{
		Point ret = new Point();
		ret.x = p.x;
		ret.y = p.y;
		return ret;
	}
	
	static Polygon convex_hull(Point in[], int n)
	{
		Polygon hull = new Polygon();
		int top;
		
		if(n<=3)
		{
			for(int i=0;i<n;i++)
				hull.p[i] = copy_point(in[i]);
			hull.n = n;
			return hull;
		}
		
		n = sort_and_remove_duplicates(in, n);
		first_point = copy_point(in[0]);
		
		Arrays.sort(in, 1, n, new Comparator() {
			public int compare(Object a, Object b)
			{
				Point p1 = (Point)a;
				Point p2 = (Point)b;
				if(collinear(first_point, p1, p2))
				{
					if(distance(first_point, p1) <= distance(first_point, p2))
						return -1;
					else
						return 1;
				}
				
				if(ccw(first_point, p1, p2))
					return -1;
				else
					return 1;
			}
		});
		
		hull.p[0] = copy_point(first_point);
		hull.p[1] = copy_point(in[1]);
		
		in[n] = copy_point(first_point);
		
		top = 1;
		int i = 2;
					
		while(i <= n)
		{
			if(!ccw(hull.p[top-1], hull.p[top], in[i]))
				top--;
			else
			{
				top++;
				hull.p[top] = copy_point(in[i]);
				i++;
			}
		}
		hull.n = top;
		return hull;
	}
	
	static int sort_and_remove_duplicates(Point in[], int n)
	{
		int i, oldn, hole;
		Arrays.sort(in, 0, n, new Comparator() {
			public int compare (Object a, Object b) {
				Point p1 = (Point) a;
				Point p2 = (Point) b;
				if(p1.x < p2.x) return -1;
				if(p1.x > p2.x) return 1;
				
				if(p1.y < p2.y) return -1;
				if(p1.y > p2.y) return 1;
				
				return 0;
			}
		});
		oldn = n;
		int ret = n;
		hole = 1;
		for(i=1;i<oldn-1;i++)
			if(in[hole-1].x==in[i].x&&in[hole-1].y==in[i].y)
				ret--;
			else
			{
				in[hole]=copy_point(in[i]);
				hole++;
			}
		in[hole] = copy_point(in[oldn-1]);
		return ret;
	}
	static public void print_polygon(Polygon p)
	{
		for(int i=0;i<p.n;i++)
			System.out.printf("(%f,%f)\n",p.p[i].x,p.p[i].y);
	}

	static public void main(String[] args)
	{
		for(int i=0;i<MAXPOLY;i++)
			in[i] = new Point();
		Polygon hull = new Polygon();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++)
		{
			in[i].x = sc.nextDouble();
			in[i].y = sc.nextDouble();
		}
		hull = convex_hull(in,n);
		print_polygon(hull);
	}
}