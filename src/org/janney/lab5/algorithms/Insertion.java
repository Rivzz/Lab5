package org.janney.lab5.algorithms;

/*
 * Insertion sort
 * 
 * Modeled from source:
 * @ https://bit.ly/2NAQp1A
 * 
 * How it works:
 * This algorithm takes the lowest value after the first value in the array, and moves it down to the first position.
 * 
 * Time complexity: 
 * (n + f(n))
 */

public class Insertion 
{
	public static void insertionSort(int[] array)
    {
		System.out.println("-----------------------------------------------");
		System.out.println("\n(Size " + array.length + ")");
		System.out.print("Initial Array: ");
		print(array);
		
		long startTime = System.nanoTime();
		
        for(int i = 1;i < array.length; i++)
        {
            int key = array[i];
            int j = i;
            while((j > 0) && (array[j - 1] > key))
            {
                array[j] = array[j - 1];
                j--;
            }
            
            array[j] = key;
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
