package practice.project.euler.problem;


import practice.project.euler.Problem;

import java.util.LinkedHashSet;
import java.util.Set;

public class Problem90 implements Problem {
    @Override
    public String getAnswer() throws Exception {

        return Integer.toString(
                getNumCombinations(-1, new LinkedHashSet<Integer>(6)) / 2
        );
    }

    private static int getNumCombinations(int curr, Set<Integer> die1) {
        if (die1.size() == 6){
            return getSecondDie(-1, die1, new LinkedHashSet<Integer>(6));
        }

        int total = 0;
        for (int i = curr + 1; i<= 9 ; i++) {
            die1.add(i);
            total += getNumCombinations(i, die1);
            die1.remove(i);
        }

        return total;
    }

    private static int getSecondDie(int curr, Set<Integer> die1, Set<Integer> die2) {
        if (die2.size() == 6)
            return (checkValid(die1, die2) ? 1 : 0);

        int total = 0;
        for (int i = curr + 1; i<= 9 ; i++) {
            die2.add(i);
            total += getSecondDie(i, die1, die2);
            die2.remove(i);
        }

        return total;
    }

    private static boolean checkValid(Set<Integer> die1, Set<Integer> die2) {
        return hasNumbers(0,1,die1,die2) &&
                hasNumbers(0,4,die1,die2) &&
                (hasNumbers(0,9,die1,die2) || hasNumbers(0,6,die1,die2)) &&
                (hasNumbers(1,6,die1,die2) || hasNumbers(1,9,die1,die2)) &&
                hasNumbers(2,5,die1,die2) &&
                (hasNumbers(3,6,die1,die2) || hasNumbers(3,9,die1,die2)) &&
                (hasNumbers(4,9,die1,die2) || hasNumbers(4,6,die1,die2)) &&
                (hasNumbers(6,4,die1,die2) || hasNumbers(9,4,die1,die2)) &&
                hasNumbers(8,1,die1,die2);


    }

    private static boolean hasNumbers(int num1, int num2, Set<Integer> die1, Set<Integer> die2) {
        return (die1.contains(num1) && die2.contains(num2)) || die1.contains(num2) && die2.contains(num1);
    }

}
