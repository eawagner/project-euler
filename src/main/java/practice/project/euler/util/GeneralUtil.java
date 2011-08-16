package practice.project.euler.util;


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

    public static long getFactorial(int num)
    {
        long retVal = 1;

        for (int i= 2;i<=num;i++)
            retVal*=i;

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

    public static int[] genNumPythagoreanTrips(int maxP) {

        int max = (int)Math.sqrt(maxP);
        int [] pTrips = new int[maxP +1];
        for (int m = 1;m<max;m+=2)
            for (int n = 2;n<max-m;n+=2)
                if (FactorUtil.gcd(m, n)==1) {
                    int sum = Math.abs(m*m - n*n) + 2*m*n + m*m + n*n;
                    for (int i = sum;i<=maxP;i+=sum)
                        pTrips[i]+=1;
                }

        return pTrips;
    }

    public static long getNumParitions(long num, Map<Long,Long> cache) {

        if (num==0)
            return 1;
        if (num<0)
            return 0;

        if (cache.containsKey(num))
            return cache.get(num);

        long retVal = 0;
        int k = 1;
        long pent = PolygonUtil.genPolyagonalNum(5,k);

        while (pent<=num) {

            int sign = (int)Math.pow(-1,k-1);

            retVal+=sign * getNumParitions(num-pent,cache);
            k*=-1;
            if (k>0)
                k++;

            pent = PolygonUtil.genPolyagonalNum(5,k);

        }

        cache.put(num,retVal);
        return retVal;
    }
}
