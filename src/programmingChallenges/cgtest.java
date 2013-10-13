package programmingChallenges;

import java.util.*;

class cgtest
{
	static final double EPSILON = 0.000001;
	
	static class Line
	{
		double a,b,c;
	}
	
	static class Point
	{
		double x,y;
	}
	
	static class segment
	{
		Point p1,p2;
	}
	
	static Line points_to_line(Point p1, Point p2)
	{
		Line L = new Line();
		if(p1.x == p2.x)
		{
			L.a = 1;
			L.b = 0;
			L.c = -p1.x;
		}
		else
		{
			L.b = 1;
			L.a = -(p1.y - p2.y) / (p1.x - p2.x);
			L.c = -(L.a * p1.x) - (L.b * p1.y);
		}
		return L;
	}
	
	static Line point_and_slope_to_line(Point p, double m)
	{
		Line L = new Line();
		L.a = -m; L.b = 1; L.c =-((L.a*p.x) + (L.b*p.y));
		return L;
	}
	
	static boolean parallelQ(Line l1, Line l2)
	{
		return ( (Math.abs(l1.a-l2.a) <= EPSILON) && (Math.abs(l1.b-l2.b) <= EPSILON) );
	}
	
	static boolean same_lineQ(Line l1, Line l2)
	{
		return ( parallelQ(l1,l2) && (Math.abs(l1.c-l2.c) <= EPSILON) );
	}
	
	static Point intersection_point(Line l1, Line l2)
	{
		Point p = new Point();
		if(same_lineQ(l1,l2))
		{
			System.out.printf("Warning: Identical lines, all points intersect.\n");
			p.x = p.y = 0.0;
			return p;
		}
		if(parallelQ(l1,l2))
		{
			System.out.printf("Error: Distinct parallel lines do not intersect.\n");
			return p;
		}
		p.x = (l2.b*l1.c - l1.b*l2.c) / (l2.a*l1.b - l1.a*l2.b);
		if (Math.abs(l1.b) > EPSILON)
			p.y = - (l1.a * (p.x) + l1.c) / l1.b;
		else
			p.y = - (l2.a * (p.x) + l2.c) / l2.b;
		return p;
	}
	
	static Point closest_point(Point p_in, Line l)
	{
		Line perp;
		Point p_c = new Point();
		if (Math.abs(l.b) <= EPSILON) {	/* vertical line */
			p_c.x = -(l.c);
			p_c.y = p_in.y;
			return p_c;
		}
		if (Math.abs(l.a) <= EPSILON) {	/* horizontal line */
			p_c.x = p_in.x;
			p_c.y = -(l.c);
			return p_c;
		}
		perp = point_and_slope_to_line(p_in,1/l.a);
		return intersection_point(l,perp);
	}
	
	static double distance(Point a, Point b)
	{
		int i;
		double d = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
		return Math.sqrt(d);
	}
	
	static void print_point(Point p)
	{
		System.out.printf("%7.3f %7.3f\n",p.x,p.y);
	}
	
	static void print_line(Line l)
	{
		System.out.printf("(a=%7.3f,b=%7.3f,c=%7.3f)\n",l.a,l.b,l.c);
	}
	
	static segment points_to_segment(Point p1,Point p2)
	{
		segment ret = new segment();
		ret.p1 = p1;
		ret.p2 = p2;
		return ret;
	}
	
	static void print_segment(segment s)
	{
		System.out.printf("segment: ");
		print_point(s.p1);
		print_point(s.p2);
	}
	
	static boolean segments_intersect(segment s1, segment s2)
	{
		Line l1 = new Line(), l2 = new Line();
		Point p = new Point();
		
		l1 = points_to_line(s1.p1,s1.p2);
		l2 = points_to_line(s2.p1,s2.p2);
		
		if (same_lineQ(l1,l2))
			return( point_in_box(s1.p1,s2.p1,s2.p2) ||
				point_in_box(s1.p2,s2.p1,s2.p2) ||
				point_in_box(s2.p1,s1.p1,s1.p2) ||
				point_in_box(s2.p2,s1.p1,s1.p2) );
		
		if (parallelQ(l1,l2)) return false;
		
		p = intersection_point(l1,l2);
		
		return( point_in_box(p,s1.p1,s1.p2) && point_in_box(p,s2.p1,s2.p2) );
	}
	
	static boolean point_in_box(Point p, Point b1, Point b2)
	{
		return( 
		(p.x >= Math.min(b1.x,b2.x)) && 
		(p.x <= Math.max(b1.x,b2.x)) && 
		(p.y >= Math.min(b1.y,b2.y)) && 
		(p.y <= Math.max(b1.y,b2.y)));
	}

	static public void main(String[] args)
	{
		Point p1 = new Point(), p2 = new Point(), q1 = new Point(), q2 = new Point(), i = new Point();
		Line l1 = new Line(), l2 = new Line(), l3 = new Line(), l4 = new Line();
		segment s1 = new segment(), s2 = new segment(), s3 = new segment(), s4 = new segment();
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			p1.x = sc.nextDouble();
			p1.y = sc.nextDouble();
			p2.x = sc.nextDouble();
			p2.y = sc.nextDouble();
			q1.x = sc.nextDouble();
			q1.y = sc.nextDouble();
			q2.x = sc.nextDouble();
			q2.y = sc.nextDouble();
			
			s1 = points_to_segment(p1,p2);
			s2 = points_to_segment(q1,q2);
			
			l1 = points_to_line(p1,p2);
			l2 = points_to_line(q1,q2);
			
			print_segment(s1);
			print_segment(s2);
			
			System.out.printf("segments_intersect test\n");
			System.out.printf("%d\n", segments_intersect(s1,s2)?1:0);
			
			System.out.printf("intersection point\n");
			i = intersection_point(l1,l2);
			print_point(i);
			
			System.out.printf("--------------------------------\n");
		}
	}
}