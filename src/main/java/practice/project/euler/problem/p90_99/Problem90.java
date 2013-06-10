package practice.project.euler.problem.p90_99;


import practice.project.euler.Problem;

import java.util.LinkedHashSet;
import java.util.Set;

/*

Each of the six faces on a cube has a different digit (0 to 9) written on it; the same is done to a second cube. By placing the two cubes side-by-side in different positions we can form a variety of 2-digit numbers.

For example, the square number 64 could be formed:

In fact, by carefully choosing the digits on both cubes it is possible to display all of the square numbers below one-hundred: 01, 04, 09, 16, 25, 36, 49, 64, and 81.

For example, one way this can be achieved is by placing {0, 5, 6, 7, 8, 9} on one cube and {1, 2, 3, 4, 8, 9} on the other cube.

However, for this problem we shall allow the 6 or 9 to be turned upside-down so that an arrangement like {0, 5, 6, 7, 8, 9} and {1, 2, 3, 4, 6, 7} allows for all nine square numbers to be displayed; otherwise it would be impossible to obtain 09.

In determining a distinct arrangement we are interested in the digits on each cube, not the order.

{1, 2, 3, 4, 5, 6} is equivalent to {3, 6, 4, 1, 2, 5}
{1, 2, 3, 4, 5, 6} is distinct from {1, 2, 3, 4, 5, 9}

But because we are allowing 6 and 9 to be reversed, the two distinct sets in the last example both represent the extended set {1, 2, 3, 4, 5, 6, 9} for the purpose of forming 2-digit numbers.

How many distinct arrangements of the two cubes allow for all of the square numbers to be displayed?

 */
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
