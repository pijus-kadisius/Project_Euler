/*
 * A permutation is an ordered arrangement of objects.
 * For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
 * If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
 * The lexicographic permutations of 0, 1 and 2 are:
 * 
 * 012   021   102   120   201   210
 * 
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
package e024_lexicographicPermutations;

import java.util.Arrays;

public class LexicographicPermutations {
	
	public static void main(String[] args) {
	
		int[] elements = {0,1,2,3,4,5,6,7,8,9};
		int[] millionthPermutation = new int[10];
		
		for(int i = 1; i<1000000; i++) {
				millionthPermutation = nextLexicographicPermutation(elements);
		}
		
		for(int a : millionthPermutation)		
			System.out.print(a+" ");
		System.out.println();
		
	}
	
	static int[] nextLexicographicPermutation(int[] elements) {
			int i = elements.length-1;
			int j = elements.length-1;
			int temp = 0;
			
			//Find largest index i such that array[i − 1] < array[i].
			while(i>0 && elements[i-1]>=elements[i])
				i--;
			
			if(i <= 0 )
				return null;
				
			//Find largest index j such that j ≥ i and array[j] > array[i − 1]
			while(elements[j]<=elements[i-1]) 
				j--;
			
			//Swap array[j] and array[i − 1]
			temp = elements[j];
			elements[j] = elements[i-1];
			elements[i-1] = temp;
			
			//Reverse the suffix starting at array[i]
			j=elements.length-1;
			while(i<j) {
				temp = elements[i];
				elements[i]=elements[j];
				elements[j]=temp;
				i++;
				j--;
			}
		return elements;
	}
}
