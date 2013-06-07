package practice.project.euler.problem;


import practice.project.euler.Problem;

import static java.util.Arrays.copyOf;

/*
By using each of the digits from the set, {1, 2, 3, 4}, exactly once, and making use of the four arithmetic operations (+, −, *, /) and brackets/parentheses, it is possible to form different positive integer targets.

For example,

8 = (4 * (1 + 3)) / 2
14 = 4 * (3 + 1 / 2)
19 = 4 * (2 + 3) − 1
36 = 3 * 4 * (2 + 1)

Note that concatenations of the digits, like 12 + 34, are not allowed.

Using the set, {1, 2, 3, 4}, it is possible to obtain thirty-one different target numbers of which 36 is the maximum, and each of the numbers 1 to 28 can be obtained before encountering the first non-expressible number.

Find the set of four distinct digits, a < b < c < d, for which the longest set of consecutive positive integers, 1 to n, can be obtained, giving your answer as a string: abcd.

 */
public class Problem93 implements Problem {

    int max = 0;
    int[] result = null;

    @Override
    public String getAnswer() throws Exception {

        calcCombos(-1, new int[4], 0);

        String answer = "";
        for (int i = 0;i< result.length;i++)
            answer += result[i];

        return answer;
    }

    //First level of recursion, get a new combo, then see what possible values the permutations produce.
    private void calcCombos(int curr, int[] currCombo, int depth) {
        if (depth == currCombo.length) {
            boolean[] results = new boolean[4 * 4 * 4 * 5]; //Max possible combinations operations can produce.
            calcPermutations(0, new int[currCombo.length], currCombo, new boolean[currCombo.length], results);

            int total = 0;
            for (int i = 1;i< results.length && results[i]; i++)
                total++;

            if (total > max) {
                max = total;
                result = copyOf(currCombo, currCombo.length);
            }

            return;
        }

        for (int i = curr + 1;i<10;i++) {
            currCombo[depth] = i;
            calcCombos(i, currCombo, depth + 1);
        }
    }

    //Next step is to generate permutation from a combination then see what values running each set of operations can produce
    private static void calcPermutations(int currIdx, int[] curr, int[] possible, boolean[] used, boolean[] results) {
        if (currIdx == possible.length) {
            calcOperations(curr, results);
            return;
        }

        for (int i = 0;i<possible.length;i++) {
            if (!used[i]) {
                used[i] = true;
                curr[currIdx] = possible[i];
                calcPermutations(currIdx + 1, curr, possible, used, results);
                used[i] = false;
            }
        }
    }

    //Actually run the complete set of operations on the array of values with each of the operations
    //against the 5 sets of parenthesis combinations.
    private static void calcOperations(int[] values, boolean[] results) {
        for (Operation i : Operation.values()) {
            for (Operation j : Operation.values()) {
                for (Operation k : Operation.values()) {

                    double number = oper(oper(oper(values[0], values[1], i), values[2], j), values[3], k);
                    if(number > 0 && number == (int)number && number < results.length)
                        results[(int)number] = true;

                    number = oper(oper(values[0], oper(values[1], values[2], j), i), values[3], k);
                    if(number > 0 && number == (int)number && number < results.length)
                        results[(int)number] = true;

                    number = oper(values[0], oper(oper(values[1], values[2], j), values[3], k), i);
                    if(number > 0 && number == (int)number && number < results.length)
                        results[(int)number] = true;

                    number = oper(values[0], oper(values[1], oper(values[2], values[3], k), j), i);
                    if(number > 0 && number == (int)number && number < results.length)
                        results[(int)number] = true;

                    number = oper(oper(values[0], values[1], i), oper(values[2], values[3], k), j);
                    if(number > 0 && number == (int)number && number < results.length)
                        results[(int)number] = true;
                }
            }
        }
    }

    //Switched from int to doubles as fractions can be made whole again from a multiplication operation which can't
    //be accounted for with ints.
    private static double oper(double a, double b, Operation op){
        if (a == -1 || b == -1)
            return -1;

        switch (op){
            case ADD:
                return a+b;
            case SUB:
                return a-b;
            case MULT:
                return a*b;
            case DIV:
                if (b == 0) return -1;
                return a/b;
        }
        return -1;
    }

    private static enum Operation {
        ADD, SUB, MULT, DIV
    }
}
