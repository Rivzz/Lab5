package org.janney.lab5;

import java.util.Scanner;

import org.janney.lab5.algorithms.Bogo;
import org.janney.lab5.algorithms.Bubble;
import org.janney.lab5.algorithms.Cocktail;
import org.janney.lab5.algorithms.Comb;
import org.janney.lab5.algorithms.Gnome;
import org.janney.lab5.algorithms.Insertion;
import org.janney.lab5.algorithms.Merge;
import org.janney.lab5.algorithms.Quick;
import org.janney.lab5.algorithms.Radix;
import org.janney.lab5.algorithms.Selection;
import org.janney.lab5.algorithms.Shell;
import org.janney.lab5.array.MakeArray;

/*
 * Main void class
 * 
 * This class contains:
 * - The main static method
 * - While loop for continuous testing
 * - Switch for sort cases
 * 
 * Calls:
 * - MakeArray
 * - Bogo
 * - Bubble
 * - Cocktail
 * - Comb
 * - Gnome
 * - Insertion
 * - Merge
 * - Quick
 * - Radix
 * - Selection
 * - Shell
 * 
 */

public class Main 
{
	public static void main(String[] args)
	{	
		Scanner scanner = new Scanner(System.in);
		Boolean cancel = false;
		
		while (!cancel)
		{
			System.out.println("-----------------------------------------------");
			System.out.println("Select a sorting algorithm from the list:\n");
			System.out.println("  Bogo, Selection, Insertion, Bubble, Quick");
			System.out.println("  Shell, Merge, Gnome, Cocktail, Radix");
			System.out.println("  My Choice: Comb");
			System.out.println("\n\tYou can exit = \"quit\"");
			
			System.out.print("\nChoice: ");
			String choice = scanner.next().toLowerCase();
			
			if (choice.equals("quit"))
				cancel = true;
			
			switch (choice)
			{
			case "bogo":
				Bogo.bogoSort(MakeArray.create(5));
				break;
			case "selection":
				Selection.selectionSort(MakeArray.create(20));
				Selection.selectionSort(MakeArray.create(100));
				Selection.selectionSort(MakeArray.create(500));
				Selection.selectionSort(MakeArray.create(1000));
				break;
			case "insertion":
				Insertion.insertionSort(MakeArray.create(20));
				Insertion.insertionSort(MakeArray.create(100));
				Insertion.insertionSort(MakeArray.create(500));
				Insertion.insertionSort(MakeArray.create(1000));
				break;
			case "bubble":
				Bubble.bubbleSort(MakeArray.create(20));
				Bubble.bubbleSort(MakeArray.create(100));
				Bubble.bubbleSort(MakeArray.create(500));
				Bubble.bubbleSort(MakeArray.create(1000));
				break;
			case "quick":
				Quick.quickSort(MakeArray.create(20));
				Quick.quickSort(MakeArray.create(100));
				Quick.quickSort(MakeArray.create(500));
				Quick.quickSort(MakeArray.create(1000));
				break;
			case "shell":
				Shell.sortShell(MakeArray.create(20));
				Shell.sortShell(MakeArray.create(100));
				Shell.sortShell(MakeArray.create(500));
				Shell.sortShell(MakeArray.create(1000));
				break;
			case "merge":
				Merge.mergeSort(MakeArray.create(20));
				Merge.mergeSort(MakeArray.create(100));
				Merge.mergeSort(MakeArray.create(500));
				Merge.mergeSort(MakeArray.create(1000));
				break;
			case "gnome":
				Gnome.gnomeSort(MakeArray.create(20));
				Gnome.gnomeSort(MakeArray.create(100));
				Gnome.gnomeSort(MakeArray.create(500));
				Gnome.gnomeSort(MakeArray.create(1000));
				break;
			case "cocktail":
				Cocktail.cocktailSort(MakeArray.create(20));
				Cocktail.cocktailSort(MakeArray.create(100));
				Cocktail.cocktailSort(MakeArray.create(500));
				Cocktail.cocktailSort(MakeArray.create(1000));
				break;
			case "radix":
				Radix.radixSort(MakeArray.createRadix(20));
				Radix.radixSort(MakeArray.createRadix(100));
				Radix.radixSort(MakeArray.createRadix(500));
				Radix.radixSort(MakeArray.createRadix(1000));
				break;
			case "comb":
				Comb.combSort(MakeArray.create(20));
				Comb.combSort(MakeArray.create(100));
				Comb.combSort(MakeArray.create(500));
				Comb.combSort(MakeArray.create(1000));
				break;
			case "quit":
				System.out.println("\n-----------------------------------------------");
				System.out.println("Exit completed");
				System.out.println("-----------------------------------------------");
				break;
			default:
				System.out.println("\nError: This is not a valid option\n");
			}
		}
		
		scanner.close();
	}
}
