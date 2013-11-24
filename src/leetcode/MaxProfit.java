package leetcode;

public class MaxProfit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] prices = {1, 2};
		System.out.println(maxProfit(prices));

	}
	
    public static int maxProfit(int[] prices) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(prices.length == 0) 
            return 0;
        
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            int delta = prices[i] - prices[i-1];
            if(delta>max)
                max = delta;
        }
        
        return max;
    }

}
