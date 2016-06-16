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
		int[] abc = findTriple();
		display(abc);
	}
	
	public static int[] findTriple() {
		int[] abc = {0,0,0};
		
		for(abc[0] = 1; abc[0]<1000; abc[0]++)
			for(abc[1] = 1; abc[1]<1000; abc[1]++)
				if( ((abc[0]*abc[0])+(abc[1]*abc[1])) == ((1000-abc[0]-abc[1])*(1000-abc[0]-abc[1])) ) {
					abc[2] = 1000-abc[0]-abc[1];
					return abc;
				}	
		
		return abc;
	}
	
	public static void display(int[] abc)
	{
		System.out.println("Pythagorean triplet of three natural numbers a<b<c, a^2+b^2=c^2 and a + b + c = 1000:\n\n"+"[ "+abc[0]+" "+abc[1]+" "+abc[2]+" ]"
				+ "\n\n"+abc[0]+" + "+abc[1]+" + "+abc[2]+" = "+(abc[0]+abc[1]+abc[2])+"\n\n"+(abc[0]*abc[0])+" + "+(abc[1]*abc[1])+" = "+(abc[2]*abc[2])+"\n\n"+((abc[0]*abc[0])+(abc[1]*abc[1]))+" = "+(abc[2]*abc[2])+".\n\n"
						+ "The product of a,b,c: "+(abc[0]*abc[1]*abc[2])+".");
	}

}
