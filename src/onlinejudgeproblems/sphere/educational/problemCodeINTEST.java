package onlinejudgeproblems.sphere.educational;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class problemCodeINTEST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		String next;
		try {
			next = stdin.readLine();
			String[] next_items = next.split(" ");
			int input_size = Integer.parseInt(next_items[0]);
			int divisor = Integer.parseInt(next_items[1]);
			int counter = 0;
			String line;
			for(int i = 0; i < input_size; i++){
				line = stdin.readLine();
				int num = Integer.parseInt(line);
				
				if(num%divisor==0)
					counter++;
			}

			System.out.println(counter);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
