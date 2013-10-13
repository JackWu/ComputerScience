package programmingChallenges.copy;
import java.util.*;

public class Polly
{
	static final int NAMELENGTH = 30;
	static final int NSUITORS = 100;	/* maximum number of suitors */
	
	static final int BESTHEIGHT = 180;	/* best height in centimeters */
	static final int BESTWEIGHT = 75;	/* best weight in kilograms */
	
	static suitor suitors[];
	static int nsuitors;

	public static void main(String[] args)
	{
		suitor suitors[] = new suitor[NSUITORS];
		for(int i = 0; i < NSUITORS; i++)
			suitors[i] = new suitor();
		int height, weight;
		
		nsuitors = 0;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			suitors[nsuitors].first = sc.next();
			suitors[nsuitors].last = sc.next();
			height = sc.nextInt();
			suitors[nsuitors].height = Math.abs(height - BESTHEIGHT);
			weight = sc.nextInt();
			if(weight > BESTWEIGHT)
				suitors[nsuitors].weight = weight - BESTWEIGHT;
			else
				suitors[nsuitors].weight = -weight;
			nsuitors++;
		}
		Arrays.sort(suitors, 0, nsuitors);
		for(int i = 0; i < nsuitors; i++)
		{
			System.out.print(suitors[i].last);
			System.out.print(", ");
			System.out.print(suitors[i].first);
			System.out.print('\n');
		}
	}
	

}