package org.janney.lab5.algorithms;

/*
 * Bogo sort
 * 
 * Modeled from source:
 * @ https://bit.ly/2CcdO3O
 * 
 * How it works:
 * This algorithm takes all the integers in the array, and basically randomly replaces them in new spots until
 * the array is sorted correctly.
 * 
 * Time complexity: 
 * (n * n!)
 */

public class Bogo 
{	
	public static void bogoSort(int[] array) 
	{
		int count = 0;
		
		System.out.println("-----------------------------------------------");
		System.out.println("\n(Because this takes so long, the set size is 5)");
		System.out.print("Initial Array: ");
		print(array);
		
		long startTime = System.nanoTime();
		
		while(!isSorted(array)) 
		{
			shuffle(array);
			count++;
		}
		
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		
		System.out.print("\nFinished Array: ");
		print(array);
		System.out.println("(Shuffled " + count + " times) " + "(" + totalTime + " ns)\n");
	}

	private static void print(int[] array) 
	{
		for (int i = 0; i < array.length; i++)
		{
			if (i == 0)
				System.out.print("{");
			
			if (i == (array.length - 1))
				System.out.println(array[i] + "}");
			else
				System.out.print(array[i] + ", ");
		}
	}

	private static void shuffle(int[] array) 
	{
		for(int i = 0; i < array.length; i++) 
		{
			int one = (int) (Math.random() * array.length),
				two = (int) (Math.random() * array.length);
			int j = array[one];
			
			array[one] = array[two];
			array[two] = j;
		}
	}

	private static boolean isSorted(int[] array) 
	{
		for(int i = 0; i < array.length - 1; i++) 
		{
			if(array[i] > array[i + 1])
				return false;
		}
		
		return true;
	}
}
