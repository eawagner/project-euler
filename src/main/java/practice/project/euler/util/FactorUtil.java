package practice.project.euler.util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.sqrt;
import static practice.project.euler.util.PrimeUtil.getNextPrime;
import static practice.project.euler.util.PrimeUtil.isPrime;

public class FactorUtil {

    public static long sumFactors(long number, Iterable<Long> primes) {
        long n = number;
        long sum = 1;

        for (long prime : primes) {
            if (n < 1 || prime * prime > n)
                break;

            if (n % prime == 0) {
                long tmp = prime * prime;
                n = n / prime;
                while (n % prime == 0) {
                    tmp = tmp * prime;
                    n = n / prime;
                }
                sum *= ((tmp - 1)/(prime - 1));
            }
        }

        if (n > 1)
            sum *= (n + 1);

        return sum - number;
    }

    public static List<Long> getFactors(long number){
        List<Long> retVal = new ArrayList<Long>();
        retVal.add(1L);

        long max = (long)sqrt(number);

        for (long i = 2;i<=max;i++) {
            if (number%i==0) {
                retVal.add(i);
                long tmp = number/i;

                if (tmp!=i)
                    retVal.add(tmp);

                if (tmp<max)
                    max = tmp;
            }
        }

        return retVal;
    }

    public static Map<Long,Integer> getPrimeFactorization(long number)
    {
        Map<Long,Integer> retVal = new HashMap<Long, Integer>();
        long prime = 1;
        if (number<2)
            return retVal;

        while (number !=1){
            prime = getNextPrime(prime);
            while (number%prime==0)
            {
                if (retVal.containsKey(prime))
                    retVal.put(prime,retVal.get(prime)+1);
                else
                    retVal.put(prime,1);

                number/=prime;
            }
        }

        return retVal;
    }

    public static Map<Long,Integer> getPrimeFactorization(long number, Iterable<Long> primes)
    {
        Map<Long,Integer> retVal = new HashMap<Long, Integer>();

        if (number<2)
            return retVal;

        for (long prime : primes) {
            while (number%prime==0)
            {
                if (retVal.containsKey(prime))
                    retVal.put(prime,retVal.get(prime)+1);
                else
                    retVal.put(prime,1);

                number/=prime;
            }
            if (number == 1)
                break;
        }

        //If the number is not 1 then there weren't enough primes to test it against
        //so check it if was prime, otherwise simply return null for now.
        if (number != 1)
            if (isPrime(number))
                retVal.put(number,1);
            else
                return null;

        return retVal;
    }

    public static long totientFunction(long num) {
        long count = 0;
        for (int i = 1;i<num;i++)
            if (gcd(num,i) == 1)
                count++;

        return count;
    }

    public static long totientFunction(long num, Iterable<Long> primes) {
        long retVal = num;
        for (Long factor : getPrimeFactorization(num,primes).keySet()) {
            retVal *= (factor-1);
            retVal /= factor;
        }
        return retVal;

    }

    public static long gcd(long a, long b) {

//        if (a<b)
//            return gcd(b,a);
//
//        if (a%b == 0)
//            return b;
//
//        return gcd(a%b,b);

//        while (b!=0) {
//            a%=b;
//            if (a==0)
//                return b;
//            b%=a;
//        }
//        return a;
        //slightly faster.
        long tmp;
        while (a>0) {
            tmp = b%a;
            b = a;
            a=tmp;
        }
        return b;
    }

}
