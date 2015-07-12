/*
 * The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
 * 
 * Find the thirteen adjacent digits in the 1000-digit number that have the greatest product.
 * What is the value of this product?
 */

package e008_largestProductInSeries;

public class largestNumberInSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String number = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		int numberLength = number.length();
		int seriesLength = 13;

		String series = "";
		String greatestSeries = "";

		//important to use long for longer series
		long greatestProduct = 1L;
		long temp = 1L;

		for (int i = 0; i < numberLength - seriesLength; i++) {
			series = number.substring(i, i + seriesLength);

			for (int j = 0; j < seriesLength; j++) {
				temp = temp * Integer.parseInt("" + series.charAt(j));
			}
			if (temp > greatestProduct) {
				greatestProduct = temp;
				greatestSeries = series;
			}
			temp = 1;
		}
		
		display(number, greatestSeries, greatestProduct);
	}

	public static void display(String number, String series, long product)
	{
		System.out.println("Thousand digit number:\n");
		displayNumber(number);
		System.out.println("\n"+series.length()+" digit sequence with largest product is " + series+".\n\nThe product of the sum"
				+ " is:\n");
		for(int i = 0; i<series.length(); i++)
		{
			if(i!=series.length()-1)
				System.out.print(series.charAt(i)+" x ");
			else
				System.out.print(series.charAt(i)+" = ");
		}
		
		System.out.println(product+".");
	}
	
	public static void displayNumber(String number) {
		for (int i = 1; i < 1001; i++) {
			System.out.print(number.charAt(i - 1));

			if (i % 50 == 0)
				System.out.print("\n");
		}
	}
}
