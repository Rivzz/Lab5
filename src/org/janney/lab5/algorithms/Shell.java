package org.janney.lab5.algorithms;

/*
 * Shell sort
 * 
 * Modeled from source:
 * @ https://bit.ly/2NBlNwH
 * 
 * How it works:
 * This algorithm takes the largest value of the array (size), and keeps reducing that value by half until it becomes
 * one. The array is sorted if all sublists of every integer are sorted
 * 
 * Time complexity: 
 * (n * log(n))
 */

public class Shell 
{
	public static void sortShell(int[] array) 
	{
		System.out.println("-----------------------------------------------");
		System.out.println("\n(Size " + array.length + ")");
		System.out.print("Initial Array: ");
		print(array);
		
		long startTime = System.nanoTime();
		
		for (int gap = array.length / 2; gap > 0; gap /= 2) 
		{
			for (int i = gap; i < array.length; i++) 
			{
				int newElement = array[i];
				int j = i;
				while (j >= gap && array[j - gap] > newElement) 
				{
					array[j] = array[j - gap];
					j -= gap;
				}
				
				array[j] = newElement;
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
