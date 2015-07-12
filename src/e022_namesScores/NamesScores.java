/*
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first 
 * names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a name score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, 
 * which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
 * So, COLIN would obtain a score of 938 × 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 */

package e022_namesScores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class NamesScores {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileName = "names.txt";
		String[] names = readNamesFromFile(fileName);

		Arrays.sort(names);
		int[] nameValues = getNameValues(names);
		long totalSum = getSum(nameValues);
		

		System.out.println("Total of all the name scores in the file: " + totalSum);
	}

	// reads text file of names; returns an array containing all names
	public static String[] readNamesFromFile(String fileName)
			throws IOException {
		String in = "";

		ArrayList<String> al = new ArrayList<String>();
		String[] a = null;
		BufferedReader reader = new BufferedReader(new FileReader(
				"/home/pk/git_workspace/ProjectEuler/src/e022_namesScores/"
						+ fileName));
		// if , or \n then move to next
		while ((in = reader.readLine()) != null) {
			// split string input at ','
			a = in.split(",");
			for (int i = 0; i < a.length; i++) {
				// remove ' " ' from all strings before adding
				al.add(a[i].replace("\"", ""));
			}
		}

		return al.toArray(new String[al.size()]);
	}

	public static int getAlphaValue(String s) {
		int val = 0;
		switch (s) {
		case "A":
			val = 1;
			break;
		case "B":
			val = 2;
			break;
		case "C":
			val = 3;
			break;
		case "D":
			val = 4;
			break;
		case "E":
			val = 5;
			break;
		case "F":
			val = 6;
			break;
		case "G":
			val = 7;
			break;
		case "H":
			val = 8;
			break;
		case "I":
			val = 9;
			break;
		case "J":
			val = 10;
			break;
		case "K":
			val = 11;
			break;
		case "L":
			val = 12;
			break;
		case "M":
			val = 13;
			break;
		case "N":
			val = 14;
			break;
		case "O":
			val = 15;
			break;
		case "P":
			val = 16;
			break;
		case "Q":
			val = 17;
			break;
		case "R":
			val = 18;
			break;
		case "S":
			val = 19;
			break;
		case "T":
			val = 20;
			break;
		case "U":
			val = 21;
			break;
		case "V":
			val = 22;
			break;
		case "W":
			val = 23;
			break;
		case "X":
			val = 24;
			break;
		case "Y":
			val = 25;
			break;
		case "Z":
			val = 26;
			break;
		}
		return val;
	}

	public static int[] getNameValues(String[] names) {
		int[] nameValues = new int[names.length];
		int sum = 0;

		for (int i = 0; i < names.length; i++) {
			for (char c : names[i].toCharArray()) {
				sum = sum + getAlphaValue("" + c);
			}
			nameValues[i] = sum;
			sum = 0;
		}

		return nameValues;
	}
	
	public static long getSum(int[] a)
	{
		long totalSum = 0;

		for (int i = 0; i < a.length; i++) {
			totalSum = totalSum + (i + 1) * a[i];
		}
		
		return totalSum;
	}
}

