package practice.project.euler.util;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.Float.floatToRawIntBits;
import static java.lang.Float.intBitsToFloat;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.util.Arrays.asList;
import static practice.project.euler.util.FactorUtil.gcd;
import static practice.project.euler.util.PolygonUtil.genPolyagonalNum;

public class GeneralUtil {

    public static BufferedReader getResource(String resource) {
        return new BufferedReader(new InputStreamReader(GeneralUtil.class.getResourceAsStream("/" + resource)));
    }

    public static boolean isSquare(long n) {
        //Found http://stackoverflow.com/questions/295579/fastest-way-to-determine-if-an-integers-square-root-is-an-integer
        switch((int)(n & 0x3F))
        {
            case 0x00: case 0x01: case 0x04: case 0x09: case 0x10: case 0x11:
            case 0x19: case 0x21: case 0x24: case 0x29: case 0x31: case 0x39:

            long sqrt = (long) sqrt(n);
            return sqrt*sqrt == n;

            default:
                return false;
        }
    }

    public static long getSum(Iterable<Long> numbers) {
        long retVal = 0;

        for (Long number : numbers)
            retVal += number;

        return retVal;
    }

    public static long getFactorial(int num) {
        long retVal = 1;

        for (int i= 2;i<=num;i++)
            retVal*=i;

        return retVal;
    }

    public static int[] getDigitFactorials() {
        int [] retVal = new int[10];
        for (int i = 0;i<retVal.length;i++)
            retVal[i] = (int) getFactorial(i);

        return retVal;
    }

    public static <T> List<List<T>> getPermutations(T... possibleValues) {
        return getPermutations(asList(possibleValues));
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

        int max = (int) sqrt(maxP);
        int [] pTrips = new int[maxP +1];
        for (int m = 1;m<max;m+=2)
            for (int n = 2;n<max-m;n+=2)
                if (gcd(m, n)==1) {
                    int sum = abs(m * m - n * n) + 2*m*n + m*m + n*n;
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
        long pent = genPolyagonalNum(5, k);

        while (pent<=num) {

            int sign = (int) pow(-1, k - 1);

            retVal+=sign * getNumParitions(num-pent,cache);
            k*=-1;
            if (k>0)
                k++;

            pent = genPolyagonalNum(5, k);

        }

        cache.put(num,retVal);
        return retVal;
    }
}
