package practice.project.euler.problem.p90_99;


import practice.project.euler.Problem;

/*

A number chain is created by continuously adding the square of the digits in a number to form a new number until it has been seen before.

For example,

44 → 32 → 13 → 10 → 1 → 1
85 → 89 → 145 → 42 → 20 → 4 → 16 → 37 → 58 → 89

Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop. What is most amazing is that EVERY starting number will eventually arrive at 1 or 89.

How many starting numbers below ten million will arrive at 89?

 */
public class Problem92 implements Problem {
    @Override
    public String getAnswer() throws Exception {
        //The extra cost of one extra recursive step is less than the cost of creating a huge cache.

        //Max size needed for cache is 9^2 * 7
        byte[] cache = new byte[9 * 9 * 7];
        cache[1] = 1;
        cache[89] = 89;

        int result = 0;
        for (int i = 2; i<= 10000000; i++) {
            if (calcChainEnd(i, cache) == 89)
                result++;
        }

        return Integer.toString(result);
    }

    private static byte calcChainEnd(int num, byte[] cache) {
        //For larger numbers reduce first before looking into cache.  Will only happen once per recursion
        if (num >= cache.length)
            return calcChainEnd(squareDigit(num), cache);

        if (cache[num] > 0)
            return cache[num];

        byte result = calcChainEnd(squareDigit(num), cache);
        cache[num] = result;
        return result;
    }

    private static int squareDigit(int num) {
        int result = 0;

        while (num > 0) {
            int digit = num % 10;
            num/= 10;
            result += digit * digit;
        }
        return result;
    }

}
