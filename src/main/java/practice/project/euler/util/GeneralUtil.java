package practice.project.euler.util;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Collection;

public class GeneralUtil {

    public static BufferedReader getResource(String resource)
    {
        return new BufferedReader(new InputStreamReader(GeneralUtil.class.getResourceAsStream("/" + resource)));
    }

    public static long getSum(Collection<Long> numbers) {
        long retVal = 0;

        for (Long number : numbers)
            retVal += number;

        return retVal;
    }

    public static BigInteger getFactorial(int num)
    {
        BigInteger retVal = new BigInteger("1");

        for (int i = 2;i<=num;i++)
            retVal = retVal.multiply(new BigInteger(Integer.toString(i)));

        return retVal;
    }



    public static boolean isTriangleNumber(long num) {
        double tmp = (Math.sqrt(1 + 8 * num) - 1) / 2;
        return (int)tmp == tmp;
    }

    public static boolean isPentagonalNumber(long num) {
        double tmp = (1 + Math.sqrt(1 + 24 * num)) / 6;
        return (int)tmp == tmp;
    }
}
