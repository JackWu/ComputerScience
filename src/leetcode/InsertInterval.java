package leetcode;

import java.util.ArrayList;

public class InsertInterval {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval a = new Interval(1, 5);
		Interval b = new Interval(6, 9);
		Interval c = new Interval(2, 7);
		ArrayList<Interval> xList = new ArrayList<Interval>();
		xList.add(a);
		//xList.add(b);
		
		Interval d = new Interval(1, 2);
		Interval e = new Interval(3, 5);
		Interval f = new Interval(6, 7);
		Interval g = new Interval(8, 10);
		Interval h = new Interval(12, 16);
		Interval k = new Interval(4, 9);
		
		ArrayList<Interval> yList = new ArrayList<Interval>();
		yList.add(d);
		yList.add(e);
		yList.add(f);
		yList.add(g);
		yList.add(h);
		
		ArrayList<Interval> sol = insert(yList, k);
		
		for(int i = 0; i < sol.size(); i++){
			System.out.print("[" + sol.get(i).start + ", " + sol.get(i).end +"] ");
		}

	}

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
		
			ArrayList<Interval> solution = new ArrayList<Interval>();
			
			Interval temp = newInterval;
			
			for(Interval i : intervals){
				if(i.end < newInterval.start){
					solution.add(i);
				}else if ( i.start > newInterval.end){
					solution.add(temp);
					temp = i;
				}else{
					temp = new Interval(Math.min(i.start, temp.start), Math.max(i.end, temp.end));
				}
			}
			
			solution.add(temp);
			
	        
	        return solution;
	        
	    }
	

}
