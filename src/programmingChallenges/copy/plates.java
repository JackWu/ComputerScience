package programmingChallenges.copy;
import java.util.*;

class plates
{
	static int dense_layers(double w, double h, double r)
	{
		double gap;
		if ((2*r) > h) return(0);
		gap = 2.0 * r * (Math.sqrt(3)/2.0);
		return( 1 + (int)Math.floor((h-2.0*r)/gap) );
	}
	
	static int plates_per_row(int row, double w, double r)
	{
		int plates_per_full_row = (int)Math.floor(w/(2*r));
		if ((row % 2) == 0) return(plates_per_full_row);
		if (((w/(2*r))-plates_per_full_row) >= 0.5) return(plates_per_full_row);
		else return(plates_per_full_row - 1);
	}
	
	static int dense_plates(double w, double l, double r)
	{
		int layers = dense_layers(w,l,r);
		return ((int)Math.ceil(layers/2.0) * plates_per_row(0,w,r) + (int)Math.floor(layers/2.0) * plates_per_row(1,w,r) );
	}
	
	static int grid_plates(double w, double h, double r)
	{
		int layers = (int)Math.floor(h/(2*r));
		return (layers * plates_per_row(0,w,r));
	}
	
	static class DoublePair
	{
		double x;
		double y;
	}
	
	static class IntPair
	{
		int x,y;
	}
	
	static IntPair array_to_hex(int xa, int ya)
	{
		IntPair ret = new IntPair();
		ret.x = xa;
		ret.y = ya - xa + (int) Math.ceil(xa/2.0);
		return ret;
	}
	
	static IntPair hex_to_array(int xh, int yh)
	{
		IntPair ret = new IntPair();
		ret.x = xh;
		ret.y = yh + xh - (int) Math.ceil(xh/2.0);
		return ret;
	}
	
	static int plates_on_top(int xh, int yh, double w, double l, double r)
	{
		int number_on_top =0, layers, rowlength, row, xla,yla,xra,yra;
		layers = dense_layers(w,l,r);
		for (row=xh+1; row<layers; row++) {
			rowlength = plates_per_row(row,w,r) - 1;
			IntPair tmp = hex_to_array(row,yh-(row-xh));
			if (tmp.y < 0) tmp.y = 0;			/* left boundary */
			IntPair tmp1 = hex_to_array(row,yh);
			if (tmp1.y > rowlength) tmp1.y = rowlength;	/* right boundary */
			number_on_top += tmp1.y - tmp.y +1;
		}
		return(number_on_top);
	}
	
	static public void main(String[] args)
	{
		double w,l,r;
		int i,j;			/* counters */
		int xh,yh,xa,ya;
		double xhf,yhf,xg,yg;
		int xmax,ymax;
		
		System.out.printf("input box width, box length, and plate radius:\n");
		Scanner sc = new Scanner(System.in);
		w = sc.nextDouble();
		l = sc.nextDouble();
		r = sc.nextDouble();
		System.out.printf("box width=%f, box length=%f, and plate radius=%f:\n",w,l,r);
		
		System.out.printf("dense packing = %d\n", dense_plates(w,l,r));
		System.out.printf("grid packing = %d\n",  grid_plates(w,l,r));
		
		xmax = (int)Math.floor(w / (2*r));
		ymax = dense_layers(w,l,r);
		
		for (i=0; i<xmax; i++)
			System.out.printf("(0,%d) has %d on top.\n",i,plates_on_top(0,i,w,l,r));
	}
}

