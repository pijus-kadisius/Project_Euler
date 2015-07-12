/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 *
 * What is the largest prime factor of the number 600851475143 ?
 */

package e003_largestPrimeFactor;

public class LargestPrimeFactor {

	public static void main(String[] args) {

		long num = 600851475143L;
		double upperBound = Math.sqrt(num);
		int largestPrimeFactor = 0;
		String numString = "" + num;

		for (int i = 2; i < upperBound; i++) {
			if (num % i == 0) {
				num = num / i;
				largestPrimeFactor = i;
			}
		}

		System.out.println("Largest prime factor of " + numString + " is "
				+ largestPrimeFactor + ".");

		/*
		 * TEST RUN
		 * 
		 * int testNum = 13195; double testUpperBound = Math.sqrt(testNum);
		 * 
		 * for(int i = 2; i< testUpperBound; i++) {
		 * //System.out.println("here"); if(testNum%i==0) { testNum=testNum/i;
		 * System.out.println(i); } }
		 */
	}
}
