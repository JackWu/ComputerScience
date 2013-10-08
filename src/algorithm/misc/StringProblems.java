package algorithm.misc;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

public class StringProblems {
	
	public void findNonRepeat(String s){
		
		
		
		HashMap<Character, Integer> countTable = new HashMap<Character, Integer>();
		
		char[] ch = s.toCharArray();
		
		char tempCh;
		
		for(int i = 0; i < ch.length; i ++){
			if(countTable.containsKey(ch[i])){
				int count = countTable.get(ch[i]);
				countTable.put(ch[i], count+=1);
			}else{
				countTable.put(ch[i], 1);
			}
		}
		
		Set<Character> charKeys = countTable.keySet();
		for(Character x: charKeys){
			
			System.out.println(x + ": " + countTable.get(x));
			
		}
		
	}
	
	public Character findFirstNonRepeatTwo(String input){
		Hashtable hashChar = new Hashtable( );

		int j, strLength;
		Character chr;
		Object oneTime = new Object( );
		Object twoTimes = new Object( );

		strLength = input.length( );

		for (j =0; j < strLength; j++)
		{
		  chr = new Character(input.charAt( j ) );
		  Object o = hashChar.get(chr);

		  /*if there is no entry for that particular 
		     character, then insert the oneTime flag:
		  */
		  if (o == null) {
		     hashChar.put(chr, oneTime );
		  }
		  /*
		   
		  */
		  else if (o == oneTime)
		  {
		    hashChar.put(chr, twoTimes);
		  }
		}

		/* go through hashtable and search for the first 
		    nonrepeated char:
		*/
		  
		for(j = 0; j < strLength ; j++)
		{
		  chr = new Character(input.charAt(j));
		  if ( hashChar.get(chr) == oneTime)
		    return chr;
		}
		/* this only returns null if the loop above doesn't find
		   a nonrepeated character in the hashtable
		*/
		return null;

		
	}
	
	public static void perm(String prefix,  String str){
		
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	        	perm(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
		
		
	}
	
	public static void swap(char[] s, int i, int j){
		
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

}
