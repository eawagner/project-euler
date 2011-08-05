package practice.project.euler.util;


import java.io.BufferedReader;
import java.io.InputStreamReader;
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

    public static long getFactorial(int num)
    {
        long retVal = 1;

        for (int i= 2;i<=num;i++)
            retVal*=i;

        return retVal;
    }
}
