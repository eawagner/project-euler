package practice.project.euler.problem.p20_29;

import practice.project.euler.Problem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

 */
public class Problem24 implements Problem{
    public String getAnswer() throws Exception {

        boolean [] available = new boolean[10];
        for (int i = 0;i<available.length;i++)
            available[i] = true;

        List<String> permutations = new ArrayList<String>(1000000);
        setPermutations("",available,permutations,1000000);


        return permutations.get(permutations.size()-1);
    }

    public void setPermutations(String currString, boolean[] available, Collection<String> permutations, int maxPermutations)
    {
        if (currString.length() >= available.length){
            permutations.add(currString);
            return;
        }

        for (int i = 0;i<10 && permutations.size()<maxPermutations;i++)
            if (available[i]) {

                available[i] = false;
                setPermutations(currString + Integer.toString(i),available,permutations,maxPermutations);
                available[i] = true;
            }
    }
}
