package programmingChallenges.copy;

import java.util.Scanner;

/*
 * Bignum
 * Implementation of large integer arithmetic: addition, subtraction,
 * multiplication, and division.
 * Chapter 5
 * 
 * By Derek Hao Hu (derekhh@cse.ust.hk)
 */

public class Bignum_test
{
	public static void main(String[] args)
	{
		int a,b;
		bignum n1 = new bignum();
		bignum n2 = new bignum();
		bignum n3 = new bignum();
		bignum zero = new bignum();
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt())
		{
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.printf("a = %d    b = %d\n",a,b);
			n1.int_2_bignum(a);
			n2.int_2_bignum(b);
			
			n3 = n1.add_bignum(n2);
			System.out.printf("addition -- ");
			n3.print_bignum();
			
			System.out.printf("compare_bignum a ? b = %d\n", n1.compare_bignum(n2));
			
			n3 = n1.subtract_bignum(n2);
			System.out.printf("subtraction -- ");
			n3.print_bignum();
			
			n3 = n1.multiply_bignum(n2);
			System.out.printf("multiplication -- ");
			n3.print_bignum();
			
			zero.int_2_bignum(0);
			if(zero.compare_bignum(n2)==0)
				System.out.printf("division -- NaN \n");
			else
			{
				n3 = n1.divide_bignum(n2);
				System.out.printf("division -- ");
				n3.print_bignum();
			}
			System.out.printf("--------------------------\n");
		}
	}
}
