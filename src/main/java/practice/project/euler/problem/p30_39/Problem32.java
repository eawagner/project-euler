package practice.project.euler.problem.p30_39;

import practice.project.euler.Problem;
import practice.project.euler.util.StringUtil;

import java.util.HashSet;
import java.util.Set;

/*
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.

 */
public class Problem32 implements Problem{
    public String getAnswer() throws Exception {

        Set<Integer> found = new HashSet<Integer>();
        int retVal = 0;

        /* Start at 2 because 1 will never produce a product does not include duplicates of the multiplier.
         For first loop only go to 100 because at most there can only be 2 digits in one of the multipliers.
         for second loop Use 4923 (simply because 9876/2)
         */
        for (int i = 2;i<100;i++)
            for (int j = (int)Math.pow(10,Integer.toString(i).length());j<4923;j++) {
                int product = i * j;
                //If there are no combinations of
                if (product > 100000)
                    break;
                String toTest = Integer.toString(i) + Integer.toString(j) + Integer.toString(product);
                if (toTest.length() == 9 &&
                        StringUtil.isPandigital(toTest) &&
                        !found.contains(product))
                {
                    found.add(product);
                    retVal += product;
                }

            }





        return Long.toString(retVal);
    }
}
