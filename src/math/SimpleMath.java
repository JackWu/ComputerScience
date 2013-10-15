package math;

public class SimpleMath {
	
	public int add_no_arithm(int a, int b){
		if(b == 0) return a;
		int sum = a | b;
		
		System.out.print("Sum: " + sum);
		int carry = (a & b) << 1;
		
		System.out.println(" Carry: " + carry);
		return add_no_arithm(sum, carry);
	}

}
