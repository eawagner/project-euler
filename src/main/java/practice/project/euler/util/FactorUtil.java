package practice.project.euler.util;


import practice.project.euler.util.model.Tuple;

import java.util.*;

public class FactorUtil {

    public static List<Long> getFactors(long number){
        List<Long> retVal = new ArrayList<Long>();
        retVal.add(1L);

        long max = (long)Math.sqrt(number);

        for (long i = 2;i<=max;i++)
            if (number%i==0) {
                retVal.add(i);
                long tmp = number/i;

                if (tmp!=i)
                    retVal.add(tmp);

                if (tmp<max)
                    max = tmp;
            }

        return retVal;
    }

    public static Map<Long,Integer> getPrimeFactorization(long number)
    {
        Map<Long,Integer> retVal = new HashMap<Long, Integer>();
        long prime = 1;
        long toTest;
        if (number<2)
            return retVal;

        while (number !=1){
            prime = PrimeUtil.getNextPrime(prime);
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

    public static Map<Long,Integer> getPrimeFactorization(long number, Collection<Long> primes)
    {
        Map<Long,Integer> retVal = new HashMap<Long, Integer>();

        long toTest;
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
            if (PrimeUtil.isPrime(number))
                retVal.put(number,1);
            else
                return null;

        return retVal;
    }



}
