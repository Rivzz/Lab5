package org.janney.lab5.array;

import java.util.Random;

/*
 * Array creation
 * Display the array as a string
 */

public class MakeArray 
{	
	private static int[] array;
	private static Integer[] radixArray;
	
	public static int[] create(int size)
	{	
		array = null;
		array = new int[size];
		Random random = new Random();
		
		for (int i = 0; i < array.length; i++)
			array[i] = random.nextInt(1000);
		
		return array;
	}
	
	public static Integer[] createRadix(int size)
	{
		radixArray = null;
		radixArray = new Integer[size];
		Random random = new Random();
		
		for (int i = 0; i < radixArray.length; i++)
			radixArray[i] = random.nextInt(10000 - 1000) + 1000;
		
		return radixArray;
	}
}
