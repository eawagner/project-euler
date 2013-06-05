package practice.project.euler.util;

import java.util.Collection;
import java.util.LinkedHashSet;

import static java.lang.Integer.numberOfTrailingZeros;
import static java.lang.Math.sqrt;

public class PrimeUtil {

    public static boolean isPrime(long test)
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

        long sqrt = (long) sqrt(test);
        long i = 5;
        while (i<=sqrt)
            if (test%(i)==0 || test%(i+2)==0)
                return false;
            else
                i+=6;

        return true;
    }

    public static boolean isPrime(long test, Collection<Long> primes){
        if (test < 2)
            return false;

        for (Long prime : primes)
        {
            if (prime * prime > test)
                return true;
            if (test%prime == 0)
                return false;
        }
        //Return false here is better than false true if collection is not big enough
        return false;
    }

    public static Iterable<Long> getPrimes(long max){
        return getPrimes(2,max);
    }

    public static Iterable<Long> getPrimes(long start, long max)
    {
        Collection<Long> primes = new LinkedHashSet<Long>();
        getPrimes(start,max,primes);
        return primes;
    }

    public static <T extends Collection<Long>> T getPrimes (long max, T container)
    {
        return getPrimes(2,max,container);
    }

    public static <T extends Collection<Long>> T getPrimes (long start, long max, T container)
    {
        for (long i = start;i<=max;i++)
            if (isPrime(i))
                container.add(i);

        return container;
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

    public static boolean isPrimeMillerRabin(int n) {
        if (n<2)
            return false;
        else if (n==2)
            return true;
        else
            return (millerRabinPass(2, n) &&
                (n<=7 || millerRabinPass(7, n)) &&
                (n<=61 || millerRabinPass(61, n)));

    }

    private static boolean millerRabinPass(int a, int n) {
        int d = n-1;
        int s = numberOfTrailingZeros(d);
        d >>= s;

        int a_to_power = modular_exponent(a,d,n);
        if (a_to_power == 1 || a_to_power == n-1)
            return true;

        for (int i = 0; i<s-1 ; i++) {
            a_to_power = modular_exponent(a_to_power,2,n);
            if (a_to_power == n-1)
                return true;
        }
        return false;
    }

    private static int modular_exponent(int base, int power, int modulus) {
        long result = 1;
        for (int i = 31;i>=0;i--) {
            result = (result*result) % modulus;
            if ((power & (1<<i)) !=0)
                result = (result*base) % modulus;
        }
        return (int)result;
    }

}
