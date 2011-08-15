package practice.project.euler.util;


import com.sun.deploy.net.proxy.StaticProxyManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

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

    public static <T> List<List<T>> getPermutations(T... possibleValues) {
        return getPermutations(Arrays.asList(possibleValues));
    }

    public static <T> List<List<T>> getPermutations(List<T> possibleValues) {
        List<List<T>> retVal = new ArrayList<List<T>>();
        boolean[] used = new boolean[possibleValues.size()];
        List<T> seed = new ArrayList<T>(possibleValues.size());
        genPermutation(seed, 0, possibleValues, used, retVal);

        return retVal;
    }

    private static <T> void genPermutation(List<T> currVal, int currIdx, List<T> possibleValues, boolean[] used, List<List<T>> retVal) {
        if (currIdx == possibleValues.size()) {
            retVal.add(new ArrayList<T>(currVal));
            return;
        }

        for (int i = 0;i<possibleValues.size();i++) {
            if (!used[i]) {
                used[i] = true;
                if (currVal.size()<=currIdx)
                    currVal.add(possibleValues.get(i));
                else
                    currVal.set(currIdx, possibleValues.get(i));
                genPermutation(currVal, currIdx + 1, possibleValues, used, retVal);
                used[i] = false;
            }
        }


    }

}
