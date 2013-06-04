package practice.project.euler.problem.p40_49;

import practice.project.euler.Problem;

import static practice.project.euler.util.PrimeUtil.isPrime;

/*
It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

9 = 7 + 2×12
15 = 7 + 2×22
21 = 3 + 2×32
25 = 7 + 2×32
27 = 19 + 2×22
33 = 31 + 2×12

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?

 */
public class Problem46 implements Problem{
    public String getAnswer() throws Exception {

        long composite = 33;

        while (true) {
            composite +=2;
            while (isPrime(composite))
                composite+=2;

            boolean found = false;
            for (int i = 1;i*i*2<composite && !found;i++)
            {
                if (isPrime(composite - (i * i * 2)))
                    found = true;
            }

            if (!found)
                return Long.toString(composite);

        }

    }
}
