package practice.project.euler.util;


import java.util.*;

public class PrimeUtil {

    public static boolean isPrime(Long test)
    {
        if (test < 2)
            return false;
        if (test < 4)
            return true;
        if (test%2 == 0)
            return false;
        if (test < 9)
            return true;
        if (test%3 == 0)
            return false;

        long sqrt = (long)Math.sqrt(test);
        long i = 5;
        while (i<=sqrt)
            if (test%(i)==0 || test%(i+2)==0)
                return false;
            else
                i+=6;

        return true;
    }

    public static Collection<Long> getPrimes(long max){
        return getPrimes(2,max);
    }

    public static Collection<Long> getPrimes(long start, long max)
    {
        Collection<Long> primes = new HashSet<Long>();
        getPrimes(start,max,primes);
        return primes;
    }

    public static void getPrimes (long max, Collection<Long> container)
    {
        getPrimes(2,max,container);
    }

    public static void getPrimes (long start, long max, Collection<Long> container)
    {
        for (long i = start;i<=max;i++) {
            if (isPrime(i)) {
                container.add(i);
            }
        }
    }

    public static long getNextPrime(long startVal)
    {
        for (long i = startVal+1;;i++)
            if (isPrime(i))
                return i;
    }

    public static long getPrevPrime(long startVal)
    {
        for (long i = startVal-1;;i--)
            if (isPrime(i))
                return i;
    }
}
