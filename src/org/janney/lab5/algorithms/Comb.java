package org.janney.lab5.algorithms;

/*
 * Comb sort
 * 
 * Modeled from source:
 * @ https://bit.ly/2PL66pl
 * 
 * How it works:
 * This algorithm is an improvement to bubble sort. It uses a gap over the basic left to right comparison,
 * it starts at 1.3 and every iteration it lowers until it reaches 1.
 * 
 * Time complexity: 
 * (n log(n))
 */

public class Comb 
{
	public static void combSort(int[] array)
	{
		System.out.println("-----------------------------------------------");
		System.out.println("\n(Size " + array.length + ")");
		System.out.print("Initial Array: ");
		print(array);
		
		long startTime = System.nanoTime();
		
		sort(array);
		
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		
		System.out.print("\nFinished Array: ");
		print(array);
		System.out.println("(" + totalTime + " ns)\n");
	}
	
    public static void sort(int[] array) 
    {
        int gap = array.length;
        float shrinkFactor = 1.3f;
        boolean swapped = false;

        while (gap > 1 || swapped) 
        {
            if (gap > 1) 
            {
                gap = (int)(gap / shrinkFactor);
            }

            swapped = false;

            for (int i = 0; gap + i < array.length; i++) 
            {
                if (array[i] > array[i + gap]) 
                {
                    swap(array, i, i + gap);
                    swapped = true;
                }
            }
        }
    }

    private static void swap(int[] array, int a, int b) 
    {
        Integer temp = array[a];
        array[a] = array[b];
        array[b] = temp;
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
