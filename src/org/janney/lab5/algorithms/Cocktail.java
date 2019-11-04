package org.janney.lab5.algorithms;

/*
 * Cocktail sort
 * 
 * Modeled from source:
 * @ https://bit.ly/2C7iwzV
 *
 * How it works:
 * This algorithm compares if the left value in the array is greater than the one on the right, if so the values
 * are swapped. At the end of each loop, the largest number will reside as the end of the array. This then
 * repeats from the opposite direction.
 * 
 * Time complexity: 
 * (n^2)
 */

public class Cocktail 
{
	public static void cocktailSort(int[] array)
	{
		boolean swapped;
		
		System.out.println("-----------------------------------------------");
		System.out.println("\n(Size " + array.length + ")");
		System.out.print("Initial Array: ");
		print(array);
		
		long startTime = System.nanoTime();
		
		do {
			swapped = false;
			
			for (int i = 0; i <= array.length - 2; i++) 
			{
				if (array[i] > array[i + 1]) 
				{
					int temp = array[i];
					
					array[i] = array[i + 1];
					array[i + 1]=temp;
					swapped = true;
				}
			}
			
			if (!swapped) 
				break;
			
			swapped = false;
			
			for (int i = array.length - 2; i >= 0; i--) 
			{
				if (array[i] > array[i + 1]) 
				{
					int temp = array[i];
					
					array[i] = array[i + 1];
					array[i + 1] = temp;
					swapped = true;
				}
			}
			
		} while (swapped);
		
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
