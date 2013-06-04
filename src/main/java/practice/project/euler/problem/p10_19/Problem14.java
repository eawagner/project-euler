package practice.project.euler.problem.p10_19;

import practice.project.euler.Problem;

/*
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:
13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.

 */
public class Problem14 implements Problem{
    public String getAnswer() {

        int longestChain = 0;
        int longest = 1;

        //Keep previously computed chains in array cache.
        int[] chains = new int[1000000];
        int chainlen;

        chains[0] = 1;
        for (int i = 2;i<1000000;i++)
        {
            chainlen = getChainLength(i,chains);

            if (chainlen> longestChain){
                longestChain = chainlen;
                longest = i;
            }
        }

        return Integer.toString(longest);
    }

    private int getChainLength(long num, int[] chains) {
        //first check cache.
        if (num<chains.length && chains[(int)num-1]>0)
            return chains[(int)num-1];

        //recursive call to get next element
        int retVal = 1;
        if (num%2==0)
            retVal += getChainLength(num/2, chains);
        else
            retVal += getChainLength((3*num) + 1, chains);

        //populate cache if number is within range
        if (num<chains.length)
            chains[(int)num-1] = retVal;

        return retVal;
    }


    private long getNextElement(long num)
    {
        if (num%2==0) return num/2;
        else return (3*num) + 1;
    }


}
