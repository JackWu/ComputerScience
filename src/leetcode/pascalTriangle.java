package leetcode;

import java.util.ArrayList;

public class pascalTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generate(3);

	}
	
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        
        if(numRows == 0)
            return result;
        
        for(int i = 0; i <= numRows-1; i++){
            ArrayList<Integer> lst = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++){
                if(j==0 || j==i){
                    lst.add(1);
                    continue;
                }
                int num = result.get(i-1).get(j-1)+result.get(i-1).get(j);
                lst.add(num);
                    
                
            }
            result.add(lst);
        
        }
        
        return result;
        
    }

}
