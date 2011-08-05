package practice.project.euler.problem.p20_29;

import practice.project.euler.Problem;
import practice.project.euler.util.FactorUtil;
import practice.project.euler.util.GeneralUtil;

import java.util.*;

/*
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

 */
public class Problem23 implements Problem{
    public String getAnswer() throws Exception {

        List<Integer> abudentNumbers = new ArrayList<Integer>(28123);


        for (int i = 12;i<28123;i++)
            if (GeneralUtil.getSum(FactorUtil.getFactors(i))>i)
                abudentNumbers.add(i);

        boolean hasSum[] = new boolean[28123];

        for (int i = 0;i<abudentNumbers.size();i++)
            for (int j = i;j<abudentNumbers.size();j++) {
                int sum = abudentNumbers.get(i) + abudentNumbers.get(j);
                if (sum >= hasSum.length)
                    break;

                hasSum[sum] = true;
            }

        long retVal = 0;
        for (int i = 0;i<28123;i++)
            if (!hasSum[i])
                retVal += i;


        return Long.toString(retVal);
    }
}
