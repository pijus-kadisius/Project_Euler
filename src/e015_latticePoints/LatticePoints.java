/*
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, 
 * there are exactly 6 routes to the bottom right corner.
 * 
 * How many such routes are there through a 20×20 grid?
 * 		
 */

package e015_latticePoints;

public class LatticePoints {
	public static void main(String[] main) {
		// for an n*n grid the total number of moves for every path
		// is 2n and there are n right and down moves
		// therefore we need to choose n moves from 2n possibilities

		int gridSize = 20;
		int totalMoves = 2 * gridSize;

		// binomial(40,20)
		System.out.println(binomial(totalMoves, gridSize));
	}

	// implementation using binomial coefficient
	public static long binomial(int n, int k) {
		if (k < 0 || k > n)
			return 0;
		if (k == 0 || k == n)
			return 1;

		// symmetry of binomial theorem.
		k = Math.min(k, n - k);

		long count = 1;

		//calculate the binomials coefficient
		for (int i = 0; i < k; i++) {
			count = count * (n - i) / (i + 1);
		}
		return count;
	}
}
