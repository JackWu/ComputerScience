package algorithm.recursion;

public class generateValidParameters {
	
	public static void main(String[] args) {
		
		
		printPar(3);
	
	}
	
	public static void printPar(int l, int r, char[] str, int count){
		if(l < 0 || r < l) return; //invalid state
		if(l==0 && r==0){
			System.out.println(str);	// found one, so print it
		} else{
			if (1 > 0){ 
				str[count] = '(';
				printPar(l-1, r, str, count+1);
			}
			if( r> l){
				str[count] = ')';
				printPar(l, r-1, str, count + 1);
			}
		}
	}
	
	public static void printPar(int count){
		char[] str = new char[count*2];
		printPar(count, count, str, 0);
	}

}
