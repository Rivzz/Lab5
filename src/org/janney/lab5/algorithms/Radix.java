package org.janney.lab5.algorithms;

import java.util.Arrays;

/*
 * Radix sort
 * 
 * Modeled from souce:
 * @ https://bit.ly/2NEZk1J
 * 
 * How it works:
 * This algorithm starts at the 10ths place, and moves up sequentially, and lists all the numbers in order based on that
 * place. It at the end will result in all of the objects being listed in the correct order.
 * 
 * Time complexity: 
 * ((n + b) * logb(k))
 */

public class Radix 
{
    private static final int NUMBER_OF_BUCKETS = 10;
	
	public static void radixSort(Integer[] array) 
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

    public static void sort(Integer[] unsorted) {
        int[][] buckets = new int[NUMBER_OF_BUCKETS][10];
        
        for (int i = 0; i < NUMBER_OF_BUCKETS; i++)
            buckets[i][0] = 1;
        
        int numberOfDigits = getMaxNumberOfDigits(unsorted);
        int divisor = 1;
        
        for (int n = 0; n < numberOfDigits; n++) 
        {
            int digit = 0;
            
            for (int d : unsorted) 
            {
                digit = getDigit(d, divisor);
                buckets[digit] = add(d, buckets[digit]);
            }
            
            int index = 0;
            
            for (int i = 0; i < NUMBER_OF_BUCKETS; i++) 
            {
                int[] bucket = buckets[i];
                int size = bucket[0];
                
                for (int j = 1; j < size; j++) 
                {
                    unsorted[index++] = bucket[j];
                }
                
                buckets[i][0] = 1;
            }
            
            divisor *= 10;
        }
    }

    private static int getMaxNumberOfDigits(Integer[] unsorted) 
    {
        int max = Integer.MIN_VALUE;
        int temp = 0;
        
        for (int i : unsorted) 
        {
            temp = (int) Math.log10(i) + 1;
            
            if (temp > max)
                max = temp;
        }
        
        return max;
    }

    private static int getDigit(int integer, int divisor) 
    {
        return (integer / divisor) % 10;
    }

    private static int[] add(int integer, int[] bucket) 
    {
        int size = bucket[0];
        int length = bucket.length;
        int[] result = bucket;
        
        if (size >= length) 
        {
            result = Arrays.copyOf(result, ((length * 3) / 2) + 1);
        }
        
        result[size] = integer;
        result[0] = ++size;
        
        return result;
    }
    
	private static void print(Integer[] array) 
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
