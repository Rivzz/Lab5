package org.janney.lab5.algorithms;

/*
 * Selection sort
 * 
 * Modeled from source:
 * @ https://bit.ly/36qKHrv
 * 
 * How it works:
 * This algorithm repeatedly fines the minimum element in ascending order from the unsorted part and puts it at the beginning of the array.
 * 
 * Time complexity: 
 * (n^2)
 */

public class Selection 
{
	public static void selectionSort(int[] array) 
	{
		System.out.println("-----------------------------------------------");
		System.out.println("\n(Size " + array.length + ")");
		System.out.print("Initial Array: ");
		print(array);
		
		long startTime = System.nanoTime();
		
		for (int i = 0; i < array.length - 1; i++) 
		{
			int currentMin = array[i];
			int currentMinIndex = i;
			
			for (int j = i + 1; j < array.length; j++) 
			{
				if (currentMin > array[j]) 
				{
					currentMin = array[j];
					currentMinIndex = j;
				}
			}

			if (currentMinIndex != i)
			{
				array[currentMinIndex] = array[i];
				array[i] = currentMin;
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
