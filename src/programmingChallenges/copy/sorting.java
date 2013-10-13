package programmingChallenges.copy;

import java.util.Random;

/*
 * Sorting
 * Implementations of primary sorting algorithms
 * Section 4.2
 * By Derek Hao Hu (derekhh@cse.ust.hk)
 */
public class sorting
{
	static final int NELEM = 100;
	
	static void swap(int a[], int i, int j)
	{
		int tmp;
		tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	static void insertion_sort(int s[], int n)
	{
		int i, j;
		for(i = 1; i < n; i++)
		{
			j = i;
			while(j > 0 && s[j] < s[j-1])
			{
				swap(s, j, j-1);
				j = j-1;
			}
		}
	}
	
	static void selection_sort(int s[], int n)
	{
		int i, j, min;
		for(i = 0; i < n; i++)
		{
			min = i;
			for(j = i + 1; j < n; j++)
				if(s[j] < s[min])
					min = j;
			swap(s, i, min);
		}
	}
	
	static void quicksort(int s[],int l,int h)
	{
		int p;
		if(h - l > 0)
		{
			p = partition(s, l, h);
			quicksort(s, l, p-1);
			quicksort(s, p+1, h);
		}
	}
	
	static int partition(int s[], int l, int h)
	{
		int i, p, firsthigh;
		p = h;
		firsthigh = l;
		for(i = l; i < h; i++)
			if(s[i] < s[p])
			{
				swap(s, i, firsthigh);
				firsthigh++;
			}
		swap(s, p, firsthigh);
		return firsthigh;
	}
	
	static void random_shuffle(int s[], int n)
	{
		Random rnd = new Random();
		for(int i = 0; i < n; i++)
			swap(s, i, rnd.nextInt(n - i + 1));
	}
	
	public static void main(String[] args)
	{
		int s[] = new int[NELEM + 2];
		int i;
		for(i = 0; i < NELEM; i++)
			s[i] = i + 1;
		random_shuffle(s, NELEM);
		System.out.printf("\n\n");
		insertion_sort(s, NELEM);
		System.out.printf("Insertion sort: \n");
		for(i = 0; i < NELEM; i++)
			System.out.printf("%d ", s[i]);
		System.out.printf("\n\n");
		
		random_shuffle(s, NELEM);
		selection_sort(s, NELEM);
		System.out.printf("Selection sort: \n");
		for(i = 0; i < NELEM; i++)
			System.out.printf("%d ", s[i]);
		System.out.printf("\n\n");
		
		random_shuffle(s, NELEM);
		quicksort(s, 0, NELEM - 1);
		System.out.printf("Quicksort: \n");
		for(i = 0; i < NELEM; i++)
			System.out.printf("%d ", s[i]);
		System.out.printf("\n\n");
	}
}