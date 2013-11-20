package leetcode;

import java.util.HashMap;

public class RomainToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int ret = romanToInteger("CCXXIV");
		
		System.out.println(ret);

	}
	
	public static int romanToInteger(String s){
		
		int ret = 0;
		
		if(s.length() <= 0)
			return ret;
		
		HashMap<Character, Integer> romanMap = new HashMap<Character, Integer>();
		
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);
		
		for(int i = s.length()-2; i >=0; i--){
		    int left = romanMap.get(Character.toUpperCase(s.charAt(i+1)));
			int right =  romanMap.get(Character.toUpperCase(s.charAt(i)));
			if(left <= right)
			    ret+=right;
			else
			    ret-=right;
		}
		
		
		return ret;
	}

}
