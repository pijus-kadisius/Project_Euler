/*
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below,
 * the maximum total from top to bottom is 23.
 *
 *    3
 *   7 4
 *  2 4 6
 * 8 5 9 3
 *
 * That is, 3 + 7 + 4 + 9 = 23.
 * 
 * Find the maximum total from top to bottom of the triangle below:
 * 
 *	 							 75
 *	 						    95 64
 *	 						  17 47 82
 *                           18 35 87 10
 *                          20 04 82 47 65
 *                        19 01 23 75 03 34
 *                       88 02 77 73 07 63 67
 *                     99 65 04 28 06 16 70 92
 *                   41 41 26 56 83 40 80 70 33
 *                 41 48 72 33 47 32 37 16 94 29
 *                53 71 44 65 25 43 91 52 97 51 14
 *              70 11 33 28 77 73 17 78 39 68 17 57
 *             91 71 52 38 17 14 91 43 58 50 27 29 48
 *           63 66 04 68 89 53 67 30 73 16 69 87 40 31
 *         04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 *
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. 
 * However, Problem 67, is the same challenge with a triangle containing one-hundred rows;
 * it cannot be solved by brute force, and requires a clever method! ;o)
 */
package e018_maximumPathSum1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MaximumPathSum1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[][] triangle = readTriangle();

		display(triangle);

		System.out.println("Maximum triangular path sum: "
				+ findMaxSum(triangle) + ".");

	}

	// implementation using techniques of Dynamic programming. Breaks down the
	// triangle into smaller triangles starting at the bottom row.
	// finds a max path between every triangle and assigns the value to its
	// apex. Continues until the apex of the large triangle has the
	// max value.
	public static int findMaxSum(int[][] triangle) {

		for (int i = 14; i > 0; i--) {
			for (int j = 0; j < triangle[i].length - 1; j++) {

				if (j == 0) {
					// left edge of the triangle
					triangle[i - 1][j] = triangle[i - 1][j]
							+ Math.max(triangle[i][j], triangle[i][j + 1]);
				} else {
					if (j == triangle.length - 1) {
						// right edge of triangle
						triangle[i - 1][j - 1] = triangle[i - 1][j - 1]
								+ Math.max(triangle[i][j], triangle[i][j - 1]);
					} else {
						// all cases except for the edges
						triangle[i - 1][j] = triangle[i - 1][j]
								+ Math.max(triangle[i][j], triangle[i][j + 1]);
					}
				}
			}
		}

		return triangle[0][0];
	}

	// reads triangle from file into a 2D int array, returns 2D array
	public static int[][] readTriangle() throws IOException {
		BufferedReader reader = new BufferedReader(
				new FileReader(
						"/home/pk/git_workspace/ProjectEuler/src/e018_maximumPathSum1/triangle.txt"));

		String in = "";
		int[] temp;
		int[][] triangle = new int[15][];
		String[][] ts = new String[15][15];

		int i = 0;

		while ((in = reader.readLine()) != null) {
			ts[i] = in.split(" ");
			// define number of columns for each row in 2D array
			triangle[i] = new int[i + 1];
			for (int j = 0; j <= i; j++) {

				triangle[i][j] = Integer.parseInt(ts[i][j]);
			}
			i++;
		}
		return triangle;
	}

	// display unformatted triangle
	public static void display(int[][] t) {
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}
}
