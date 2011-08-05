package practice.project.euler.problem.p30_39;

import practice.project.euler.Problem;

/*
In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

    1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).

It is possible to make £2 in the following way:

    1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p

How many different ways can £2 be made using any number of coins?

 */
public class Problem31 implements Problem{
    public String getAnswer() throws Exception {

        int[] denominations = new int[] {1,2,5,10,20,50,100,200};

        return Integer.toString(numCombinations(0, 0, denominations, 200));
    }

    private int numCombinations(int currVal, int currIdx, int[] denominations, int desiredVal) {
        if (currVal == desiredVal)
            return 1;

        if (currVal > desiredVal || currIdx >= denominations.length)
            return 0;

        int retVal = 0;

        for (int i = currVal; i<=desiredVal; i+= denominations[currIdx])
            retVal+= numCombinations(i, currIdx + 1, denominations, desiredVal);

        return retVal;
    }
}
