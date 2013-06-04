package practice.project.euler.problem.p60_69;

import practice.project.euler.Problem;

import static practice.project.euler.util.PrimeUtil.getNextPrime;

/*
Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine the number of numbers less than n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively prime to nine, φ(9)=6.
n 	Relatively Prime 	φ(n) 	n/φ(n)
2 	1 	1 	2
3 	1,2 	2 	1.5
4 	1,3 	2 	2
5 	1,2,3,4 	4 	1.25
6 	1,5 	2 	3
7 	1,2,3,4,5,6 	6 	1.1666...
8 	1,3,5,7 	4 	2
9 	1,2,4,5,7,8 	6 	1.5
10 	1,3,7,9 	4 	2.5

It can be seen that n=6 produces a maximum n/φ(n) for n ≤ 10.

Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.

 */
public class Problem69 implements Problem{
    public String getAnswer() throws Exception {

        long currPrime = getNextPrime(1);
        int retVal = 1;

        while (true) {
            if (retVal*currPrime<=1000000)
                retVal*=currPrime;
            else
                return Integer.toString(retVal);

            currPrime = getNextPrime(currPrime);
        }

    }
}
