package practice.project.euler.problem.p80_89;


import practice.project.euler.Problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Math.sqrt;

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

        /* Not gonna lie, I found the current solution from the forums and found it great
         * I left the old recursive calls below for reference.
         */

        int N = 13000;
        int[] minSum = new int[N];
        List<HashSet<Integer>> sums = new ArrayList<HashSet<Integer>>(N);

        for (int i = 2; i < N; i++) {
            sums.add(new HashSet<Integer>());
            sums.get(i-2).add(i-1);
            for (int j = (int) sqrt(i); j > 1; j--) {
                if (i % j == 0) {
                    for (int k : sums.get(i/j -2)) {
                        int s = j - 1 + k;
                        if (i - s >= 2 && minSum[i - s] == 0)
                            minSum[i - s] = i;
                        sums.get(i-2).add(j - 1 + k);
                    }
                }
            }
        }

        Set<Integer> unique = new HashSet<Integer>(12000);
        int sum = 0;
        for (int i = 0;i<=12000; i++) {
            if (!unique.contains(minSum[i])) {
                unique.add(minSum[i]);
                sum+=minSum[i];
            }
        }
        return Integer.toString(sum);
    }

    /* Used this previously, but above solution is much faster*/
//
//    private static int getMin(int k) {
//        //All possible values of psn are k< psn <=2*k.  No need to check upperbound,
//        // as it will stop the first value it finds.
//        for(int psn = k+1; ; psn++)
//            if(solvable(psn, psn, k))
//                return psn;
//
//
//    }
//
//    private static boolean solvable(int prod, int sum, int k) {
//        if(sum < k)
//            return false;
//        if(prod == 1)
//            return sum == k;
//        if(k == 1)
//            return prod == sum;
//
//        for(int d = 2; d <= prod && sum-d >= k-1; d++)
//            if(prod%d == 0)
//                if(solvable(prod / d, sum - d, k - 1))
//                    return true;
//
//        return false;
//    }

}
