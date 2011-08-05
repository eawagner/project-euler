package practice.project.euler.util;


import practice.project.euler.util.model.Tuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static Tuple<Long,Long> reduceFraction(long numerator, long denominator) {
        Map<Long, Integer> numFactors = getPrimeFactorization(numerator);
        Map<Long, Integer> denFactors = getPrimeFactorization(denominator);

        for (Map.Entry<Long,Integer> factor : numFactors.entrySet()) {
            int numDivisions = (
                    numFactors.get(factor.getKey())>denFactors.get(factor.getKey())
                            ?denFactors.get(factor.getKey()):numFactors.get(factor.getKey()));

            for (int i = 0;i<numDivisions;i++)
            {
                numerator /= factor.getKey();
                denominator /= factor.getKey();
            }
        }

        return new Tuple<Long, Long>(numerator,denominator);
    }

}
