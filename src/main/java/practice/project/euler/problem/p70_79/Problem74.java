package practice.project.euler.problem.p70_79;

import practice.project.euler.Problem;
import practice.project.euler.problem.p30_39.Problem34;
import practice.project.euler.util.GeneralUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
The number 145 is well known for the property that the sum of the factorial of its digits is equal to 145:

1! + 4! + 5! = 1 + 24 + 120 = 145

Perhaps less well known is 169, in that it produces the longest chain of numbers that link back to 169; it turns out that there are only three such loops that exist:

169 → 363601 → 1454 → 169
871 → 45361 → 871
872 → 45362 → 872

It is not difficult to prove that EVERY starting number will eventually get stuck in a loop. For example,

69 → 363600 → 1454 → 169 → 363601 (→ 1454)
78 → 45360 → 871 → 45361 (→ 871)
540 → 145 (→ 145)

Starting with 69 produces a chain of five non-repeating terms, but the longest non-repeating chain with a starting number below one million is sixty terms.

How many chains, with a starting number below one million, contain exactly sixty non-repeating terms?

 */
public class Problem74 implements Problem{
    public String getAnswer() throws Exception {
        Map<Integer,Integer> cache = new HashMap<Integer, Integer>();
        Stack<Integer> currChain = new Stack<Integer>();
        int [] digitFactorials = Problem34.getDigitFactorials();
        int retVal = 0;
        for (int i = 1;i<1000000;i++) {

            if (cache.containsKey(i))
                continue;

            currChain.push(i);

            int lastElement = Problem34.getNextItem(i,digitFactorials);
            while (!currChain.contains(lastElement)  && !cache.containsKey(lastElement)) {
                currChain.push(lastElement);
                lastElement = Problem34.getNextItem(lastElement,digitFactorials);
            }

            int additionalAmount = 0;
            if (cache.containsKey(lastElement)) {
                additionalAmount = cache.get(lastElement);
            } else {
                //every element in the cycle will have same cycle size, so pop all of them off.
                additionalAmount = currChain.size() - currChain.indexOf(lastElement);
                boolean found = false;
                while (!found) {
                    int currVal = currChain.pop();
                    found = (currVal == lastElement);
                    cache.put(currVal,additionalAmount);
                }
            }

            int n = 1;
            while (!currChain.empty()) {
                    cache.put(currChain.pop(),n+additionalAmount);
                    n++;
                }




        }

        for (Integer chainLen : cache.values())
            if(chainLen>=60)
                retVal++;

        return Integer.toString(retVal);
    }

}
