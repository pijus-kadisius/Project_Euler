/*
 * The program calculates the sum of all multiples of 3 and 5 that are below 1000
 */

package e001_multiplesOf3_5;

public class MultiplesSum {
	public static void main(String[] args)
	{
		int sum = 0;
	
		for(int i=0; i<1000; i++)
		{
			
			if(i%3==0||i%5==0)
			{
				sum=sum+i;
				System.out.println("i: "+i+"\nsum"+sum);
			}
		}
		
		System.out.println("the sum of all multiples of 3 and 5 that are below 1000 is: "+sum+".");	
	}
	
	
}
