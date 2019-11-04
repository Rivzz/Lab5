package org.janney.lab5.algorithms;

/*
 * Gnome sort
 * 
 * Modeled from source:
 * @ https://bit.ly/34v4JQ3
 * 
 * How it works:
 * This algorithm compares the right integer with the left, and if they are in the right order, it will step forward,
 * otherwise it will swap and step one back.
 * 
 * Time complexity: 
 * (n^2)
 */

public class Gnome 
{
    public static void gnomeSort(int[] array) 
    {
        int i = 1;
        int n = array.length;
        
		System.out.println("-----------------------------------------------");
		System.out.println("\n(Size " + array.length + ")");
		System.out.print("Initial Array: ");
		print(array);
		
		long startTime = System.nanoTime();
        
        while (i < n) 
        {
            if (i == 0 || array[i - 1] <= array[i]) 
                i++;
            else 
            {
                int temp = array[i];
                
                array[i] = array[i - 1];
                array[--i] = temp;
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
