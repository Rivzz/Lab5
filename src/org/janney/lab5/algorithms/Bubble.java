package org.janney.lab5.algorithms;

/*
 * Bubble sort
 * 
 * Modeled from source:
 * @ https://bit.ly/33b3kO8
 * 
 * How it works:
 * This algorithm compares the right integer in the array to the left, and checks if it is lower than the next,
 * if this is true, then it swaps them
 * 
 * Time complexity: 
 * (n)
 */

public class Bubble 
{
	public static void bubbleSort (int[] array) 
	{
		int i, j, temp = 0;
		
		System.out.println("-----------------------------------------------");
		System.out.println("\n(Size " + array.length + ")");
		System.out.print("Initial Array: ");
		print(array);
		
		long startTime = System.nanoTime();
		
		for (i = 0; i < array.length - 1; i++) 
		{
			for (j = 0; j < array.length - 1 - i; j++) 
			{
				if (array[j] > array[j + 1])
				{
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		
		System.out.print("\nFinished Array: ");
		print(array);
		System.out.println("(" + totalTime + " ns)\n");
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
}
