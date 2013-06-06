package practice.project.euler.problem.p20_29;

import practice.project.euler.Problem;

import static practice.project.euler.util.GeneralUtil.getDigitFactorials;

/*
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

 */
public class Problem24 implements Problem{
    public String getAnswer() throws Exception {

        //First first digit has 9! permutations, second 8!, third 7! ...
        //Since we are looking for the 1M th, simply find out which digit
        //fits would exceed the threshold of what is left

        int[] factorials = getDigitFactorials();

        long left = 1000000;
        String answer = "";

        while (answer.length() < 10) {
            for (int i = 0; i< 10; i++) {
                if (!answer.contains(Integer.toString(i))) {
                    if (left - factorials[9 - answer.length()] > 0) {
                        left = left - factorials[9 - answer.length()];
                    } else {
                        answer += Integer.toString(i);
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
