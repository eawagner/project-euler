package practice.project.euler.problem.p60_69;

import practice.project.euler.Problem;

import java.util.ArrayList;
import java.util.List;

import static practice.project.euler.util.PrimeUtil.getPrimes;
import static practice.project.euler.util.PrimeUtil.isPrime;

/*
The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating them in any order the result will always be prime. For example, taking 7 and 109, both 7109 and 1097 are prime. The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.

Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.

 */
public class Problem60 implements Problem{
    public String getAnswer() throws Exception {

        List<Long> indexedPrimes = new ArrayList<Long>();
        getPrimes(10000, indexedPrimes);
        boolean pairs[][] = new boolean[indexedPrimes.size()][indexedPrimes.size()];
        long aOrder = 10;

        for (int a = 0;a<indexedPrimes.size();a++) {
            if (indexedPrimes.get(a) > aOrder)
                aOrder *=10;

            long bOrder = 10;
            for (int b = 0;b<a;b++) {
                if (indexedPrimes.get(b) > bOrder)
                    bOrder *=10;

                if (isPrime((indexedPrimes.get(a) * bOrder) + indexedPrimes.get(b), indexedPrimes) &&
                        isPrime((indexedPrimes.get(b) * aOrder) + indexedPrimes.get(a), indexedPrimes)) {
                    pairs[a][b] = true;
                    pairs[b][a] = true;
                }

                if (pairs[a][b])
                    for (int c =0;c<b;c++)
                        if (pairs[a][c] && pairs[b][c])
                            for (int d = 0;d<c;d++)
                                if (pairs[a][d] && pairs[b][d] && pairs[c][d])
                                    for (int e = 0;e<d;e++)
                                        if (pairs[a][e] && pairs[b][e] && pairs[c][e] && pairs[d][e])
                                            return Long.toString(
                                                    indexedPrimes.get(a) +
                                                    indexedPrimes.get(b) +
                                                    indexedPrimes.get(c) +
                                                    indexedPrimes.get(d) +
                                                    indexedPrimes.get(e));
            }

        }

        return null;
    }



}
