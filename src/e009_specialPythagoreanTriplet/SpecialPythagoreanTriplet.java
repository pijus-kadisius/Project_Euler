/*
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product a*b*c.
 */

package e009_specialPythagoreanTriplet;

public class SpecialPythagoreanTriplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// initial values
		int a = 0;
		int b = 0;
		int c = 0;

		for (int i = 1; i < 1001; i++) {

			for (int j = 1; j < 1001 - i; j++) {
				if (a + b < 1000) {
					if (i + j + (1000 - i - j) == 1000
							&& (i * i) + (j * j) == (1000 - i - j)
									* (1000 - i - j)) {
						a = i;
						b = j;
						c = 1000 - a - b;
					}
				}

			}
		}
		display(a, b, c);
	}
	
	public static void display(int a, int b, int c)
	{
		System.out.println("Pythagorean triplet of three natural numbers a<b<c, a^2+b^2=c^2 and a + b + c = 1000:\n\n"+"[ "+a+" "+b+" "+c+" ]"
				+ "\n\n"+a+" + "+b+" + "+c+" = "+(a+b+c)+"\n\n"+(a*a)+" + "+(b*b)+" = "+(c*c)+"\n\n"+((a*a)+(b*b))+" = "+(c*c)+".\n\n"
						+ "The product of a,b,c: "+(a*b*c)+".");
	}

}
