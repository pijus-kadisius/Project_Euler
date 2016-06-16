/*
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 * 
 * Number will be read in from text file.
 */


package e013_largeSum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigInteger;

public class LargeSum {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader;
		String in="";
		String[] sarray = new String[100];
		BigInteger bi;
		BigInteger sum = new BigInteger("0");
		String out="";
		
		reader = new BufferedReader(new FileReader("/home/pk/git/Project_Euler/src/e013_largeSum/largeNumber.txt"));
		
		int i = 0;
		while((in = reader.readLine())!=null)
		{
			sarray[i]=in;
			i++;
		}

		for(i = 0; i<sarray.length; i++)
		{
			bi= new BigInteger(sarray[i]);
			sum = sum.add(bi);
		}
		System.out.println(sum.toString().substring(0, 10));
		
	}
}
