package practice.project.euler.problem.p30_39;

import practice.project.euler.Problem;

import java.util.List;

import static java.util.Arrays.asList;

/*
In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

    1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).

It is possible to make £2 in the following way:

    1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p

How many different ways can £2 be made using any number of coins?

 */
public class Problem31 implements Problem{
    public String getAnswer() throws Exception {

        Long[] tmp = new Long[] {1L,2L,5L,10L,20L,50L,100L,200L};

        return Integer.toString(count(200, tmp.length-1, asList(tmp)));
    }

    public static int count(int n, int m, List<Long>  values) {
        if (n==0)
            return 1;
        else if (n<0)
            return 0;
        else if (m<0 && n>=1)
            return 0;

        return count(n,m-1,values) + count(n-values.get(m).intValue(),m,values);
    }
}
