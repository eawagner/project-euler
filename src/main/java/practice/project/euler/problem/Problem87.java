package practice.project.euler.problem;

import practice.project.euler.Problem;

import static java.lang.Math.sqrt;
import static practice.project.euler.util.PrimeUtil.getPrimes;

/*


The smallest number expressible as the sum of a prime square, prime cube, and prime fourth power is 28. In fact, there are exactly four numbers below fifty that can be expressed in such a way:

28 = 22 + 23 + 24
33 = 32 + 23 + 24
49 = 52 + 23 + 24
47 = 22 + 33 + 24

How many numbers below fifty million can be expressed as the sum of a prime square, prime cube, and prime fourth power?

 */
public class Problem87 implements Problem {
    private static int TARGET = 50000000;

    @Override
    public String getAnswer() throws Exception {
        //Reworked this to use a boolean cache instead of a Set for a major jump in performance.

        //Max is Prime is x^2 + 2^3 + 2^4
        int max = (int) sqrt(TARGET - 8 - 16);
        Iterable<Long> primes = getPrimes(max);
        boolean[] cache = new boolean[TARGET];
        int count = 0;

        for (long p4 : primes) {
            long c = p4 * p4 * p4 * p4;
            if (c > TARGET)
                break;

            for (long p3 : primes) {
                long b = p3 * p3 * p3;
                if (b + c > TARGET)
                    break;

                for (long p2 : primes) {
                    long a = p2 * p2;
                    if (a + b + c > TARGET)
                        break;

                    if (!cache[(int)(a + b + c)]) {
                        cache[(int)(a + b + c)] = true;
                        count++;
                    }
                }
            }
        }

        return Integer.toString(count);


//        Collection<Long> values = new HashSet<Long>();
//        for (long p4 : primes) {
//            long c = p4 * p4 * p4 * p4;
//            if (c > TARGET)
//                break;
//
//            for (long p3 : primes) {
//                long b = p3 * p3 * p3;
//                if (b + c > TARGET)
//                    break;
//
//                for (long p2 : primes) {
//                    long a = p2 * p2;
//                    if (a + b + c > TARGET)
//                        break;
//
//                    values.add(a + b + c);
//
//                }
//            }
//        }
//
//        return Integer.toString(values.size());
    }
}
