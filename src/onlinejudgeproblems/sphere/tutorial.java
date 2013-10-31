package onlinejudgeproblems.sphere;

import java.util.Scanner;

class tutorial {
	
	public void divisible(){
		Scanner in = new Scanner(System.in);
		
		String next = in.nextLine();
		String[] next_items = next.split(" ");
		int input_size = Integer.parseInt(next_items[0]);
		int divisor = Integer.parseInt(next_items[1]);
		int counter = 0;
		
		for(int i = 0; i < input_size; i++){
			
			if(in.nextInt()%divisor == 0)
				counter++;
			
		}
		
		System.out.println(counter);
		
	}
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		while(true){
			int x = in.nextInt();
			if(x == 42)
				break;
			System.out.println(x);
		}
		
	}

}
