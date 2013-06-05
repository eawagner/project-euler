package practice.project.euler.problem;


import practice.project.euler.Problem;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.fill;

/*


A natural number, N, that can be written as the sum and product of a given set of at least two natural numbers, {a1, a2, ... , ak} is called a product-sum number: N = a1 + a2 + ... + ak = a1 × a2 × ... × ak.

For example, 6 = 1 + 2 + 3 = 1 × 2 × 3.

For a given set of size, k, we shall call the smallest N with this property a minimal product-sum number. The minimal product-sum numbers for sets of size, k = 2, 3, 4, 5, and 6 are as follows.

k=2: 4 = 2 × 2 = 2 + 2
k=3: 6 = 1 × 2 × 3 = 1 + 2 + 3
k=4: 8 = 1 × 1 × 2 × 4 = 1 + 1 + 2 + 4
k=5: 8 = 1 × 1 × 2 × 2 × 2 = 1 + 1 + 2 + 2 + 2
k=6: 12 = 1 × 1 × 1 × 1 × 2 × 6 = 1 + 1 + 1 + 1 + 2 + 6

Hence for 2≤k≤6, the sum of all the minimal product-sum numbers is 4+6+8+12 = 30; note that 8 is only counted once in the sum.

In fact, as the complete set of minimal product-sum numbers for 2≤k≤12 is {4, 6, 8, 12, 15, 16}, the sum is 61.

What is the sum of all the minimal product-sum numbers for 2≤k≤12000?

 */
public class Problem88 implements Problem {

    @Override
    public String getAnswer() throws Exception {
        Set<Integer> unique = new HashSet<Integer>(12000);
        int sum = 0;
        for (int k = 2;k<=12000; k++) {
            int min = getMin(k);
            if (!unique.contains(min)) {
                unique.add(min);
                sum+=min;
            }
        }
        return Integer.toString(sum);
    }

    public int getMin(int k) {
        //All possible values of psn are k< psn <=2*k.  No need to check upperbound,
        // as it will stop the first value it finds.
        for(int psn = k+1; ; psn++)
            if(solvable(psn, psn, k))
                return psn;


    }

    public boolean solvable(int prod, int sum, int k) {
        if(sum < k)
            return false;
        if(prod == 1)
            return sum == k;
        if(k == 1)
            return prod == sum;

        for(int d = 2; d <= prod && sum-d >= k-1; d++)
            if(prod%d == 0)
                if(solvable(prod / d, sum - d, k - 1))
                    return true;

        return false;
    }

}
