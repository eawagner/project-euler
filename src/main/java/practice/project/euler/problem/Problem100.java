package practice.project.euler.problem;


import practice.project.euler.Problem;

import static java.lang.Math.sqrt;

/*
If a box contains twenty-one coloured discs, composed of fifteen blue discs and six red discs, and two discs were taken at random, it can be seen that the probability of taking two blue discs, P(BB) = (15/21)×(14/20) = 1/2.

The next such arrangement, for which there is exactly 50% chance of taking two blue discs at random, is a box containing eighty-five blue discs and thirty-five red discs.

By finding the first arrangement to contain over 1012 = 1,000,000,000,000 discs in total, determine the number of blue discs that the box would contain.

 */
public class Problem100 implements Problem {
    @Override
    public String getAnswer() throws Exception {

        // => 2b^2 - n^2 - 2b  + n = 0

        //Based on b/n * (b-1)/(n-1) = 1/2
        // => b * (b-1) = (n * (n -1))/2
        // => 2b^2 - 2b = n^2 - n
        // => 2b^2 - 2b - n^2 + n = 0
        // Finally, this site gave the solution to solving this. http://www.alpertron.com.ar/QUAD.HTM
        long b = 15;
        long n = 21;

        while(n < 1000000000000L){
            long btemp = 3 * b + 2 * n - 2;
            long ntemp = 4 * b + 3 * n - 3;

            b = btemp;
            n = ntemp;
        }
        return Long.toString(b);

        //First and very very slow solution
//        //Using the following insight b/n * (b-1)/(n-1) ~= b^2/n^2 ~= 1/2
//        //Solve for b = sqrt(n^2 / 2) = n / sqrt(2)
//
//        long n = 1000000000000L;
//        double tmp = 1.0/ sqrt(2);
//        while (true) {
//            long b = (long)(n * tmp) + 1;
//            if (2 * b * (b - 1) == n * (n - 1))
//                return Long.toString(b);
//
//            n++;
//        }


    }
}
