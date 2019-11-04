package org.janney.lab5.algorithms;

import java.util.Random;

/*
 * Quick sort
 * 
 * Modeled from source:
 * @ https://bit.ly/2C9Z9Gs
 * 
 * How it works:
 * This algorithm puts an integer at its correct position in a sorted array and puts all the smaller elements before itself, and puts all
 * elements greater than that integer ahead of itself.
 * 
 * Time complexity: 
 * (n^2)
 */

public class Quick 
{
	public static void quickSort(int[] array) 
	{
		System.out.println("-----------------------------------------------");
		System.out.println("\n(Size " + array.length + ")");
		System.out.print("Initial Array: ");
		print(array);
		
		long startTime = System.nanoTime();
		
		quickSort(array, 0, array.length-1);
		
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		
		System.out.print("\nFinished Array: ");
		print(array);
		System.out.println("(" + totalTime + " ns)\n");
	}
	
	private static void quickSort(int[] array, int low, int high) 
	{
		if (low < high + 1) 
		{
			int p = partition(array, low, high);
			
			quickSort(array, low, p - 1);
			quickSort(array, p + 1, high);
		}
	}

	private static void swap(int[] array, int index1, int index2) 
	{
		int temp = array[index1];
		
		array[index1] = array[index2];
		array[index2] = temp;		
	}
	
	private static int getPivot(int low, int high) 
	{
		Random rand = new Random();
		
		return rand.nextInt((high - low) + 1) + low;
	}

	private static int partition(int[] array, int low, int high) 
	{
		swap(array, low, getPivot(low, high));
		
		int border = low + 1;
		
		for (int i = border; i <= high; i++) 
			if (array[i] < array[low]) 
				swap(array, i, border++);
		
		swap(array, low, border - 1);
		
		return border-1;
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
