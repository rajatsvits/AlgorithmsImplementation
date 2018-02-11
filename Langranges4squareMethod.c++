/*package whatever //do not write package name here 
Adrien-Marie Legendre completed the theorem in 1797–8 with his three-square theorem, by proving that a positive integer can
be expressed as the sum of three squares if and only if it is not of the form {\displaystyle 4^{k}(8m+7)} 4^{k}(8m+7)
for integers {\displaystyle k} k and {\displaystyle m} m. Later, in 1834*
/

import java.io.*;

class GFG {
    public static boolean isSquare(int n) {
        double sqrt = Math.sqrt(n);
        int x = (int) sqrt;
        return (Math.pow(sqrt, 2) == Math.pow(x, 2));
    }

    // Lagrange's Four Square theorem , answer can be 1,2,3 or 4
    public static int getMinNumberOfSquares(int sum) {
        // case:1
        // If answer is 1 => sum is perfect square
        if (isSquare(sum))
            return 1;

        //case:2
        //If answer is 2 => one factor has to be (int)square_root and remaining other number has to be a perfect square
        int sqrt = (int) (Math.sqrt(sum));
        for (int i = 1; i <= sqrt; i++) {
            if (isSquare(sum - i * i))
                return 2;
        }

        //case:3
        //Let's come back to this in a min

        //case:4
        //from wiki
        //a positive integer can be expressed as the sum of three squares if and only if it is not of the form 4^k(8m+7) for some int k and m
        //see "not of" in above line
        while (sum % 4 == 0) //handling 4^k
            sum = sum / 4;
        if (sum % 8 == 7) //handling 8m+7
            return 4;

        // if none of above, case 3
        return 3;
    }
	public static void main (String[] args) {
		System.out.println(getMinNumberOfSquares(6)); //ans 3
		System.out.println(getMinNumberOfSquares(8)); //ans 2
		System.out.println(getMinNumberOfSquares(9)); //ans 1
		System.out.println(getMinNumberOfSquares(7)); //ans 4
	}
}
