package org.janney.lab5.algorithms;

/*
 * Merge sort
 * 
 * Modeled from source:
 * @ https://bit.ly/2JIDBVt
 * 
 * How it works:
 * This algorithm divides the array into two halves, and then proceeds to merge those two sorted halves after it divides
 * them all out. Then it eventually puts the sorted halves back into order.
 * 
 * Time complexity: 
 * (n log(n))
 */

public class Merge 
{
	public static void mergeSort(int[] array) {
		
		int[] helper = new int[array.length];
		
		System.out.println("-----------------------------------------------");
		System.out.println("\n(Size " + array.length + ")");
		System.out.print("Initial Array: ");
		print(array);
		
		long startTime = System.nanoTime();
		
		mergeSort(array, helper, 0, array.length - 1);
		
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		
		System.out.print("\nFinished Array: ");
		print(array);
		System.out.println("(" + totalTime + " ns)\n");
	}

	private static void mergeSort(int[] array, int[] helper, int low, int high) 
	{
		if (low < high) 
		{
			int middle = (low + high) / 2;
			
			mergeSort(array, helper, low, middle);
			mergeSort(array, helper, middle+1, high);
			merge(array, helper, low, middle, high);
		}
	}

	private static void merge(int[] array, int[] helper, int low, int middle, int high) 
	{
		for (int i = low; i <= high; i++) 
		{
			helper[i] = array[i];
		}

		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;

		while (helperLeft <= middle && helperRight <= high) 
		{
			if (helper[helperLeft] <= helper[helperRight]) 
			{
				array[current] = helper[helperLeft];
				helperLeft++;
			} 
			else 
			{
				array[current] = helper[helperRight];
				helperRight++;
			}
			
			current++;
		}

		int remaining = middle - helperLeft;
		
		for (int i = 0; i <= remaining; i++) 
		{
			array[current + i] = helper[helperLeft + i];
		}
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
