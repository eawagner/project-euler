package practice.project.euler.util;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static Set<Long> getPrimes(long max){
        Set<Long> primes = new HashSet<Long>();

        for (long i = 2;i<=max;i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
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
