package practice.project.euler.problem.p30_39;

import practice.project.euler.Problem;
import practice.project.euler.util.FractionUtil;
import practice.project.euler.util.model.Tuple;

/*
The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find the value of the denominator.

 */
public class Problem33 implements Problem{
    public String getAnswer() throws Exception {

        long retNum = 1;
        long retDen = 1;
//
//        for (int i = 10;i<100;i++)
//            for (int j = i + 1;j<100;j++)
//                if ((i%10 == j/10 || i%10 == j%10 ||
//                        i/10 == j/10 || i/10 == j%10) &&
//
//
//                        )
//
//

        //Since the second digit in the numerator is the first digit in the denominator, in order for the fraction to be
        //less than one the second digit in the numberator will always be larger;


        for (int firstDig = 1;firstDig < 10;firstDig++)
            for (int secondDig = firstDig+1;secondDig<10;secondDig++) {
                int numerator = firstDig * 10 + secondDig;

                for (int denom = secondDig * 10 + 1; denom < (secondDig * 10) + 10;denom++)
                    //if the numbers are not the same and the division of the number equals the division
                    //of the first digit of the numberator and the second digit of the divisor then found match
                    if ((numerator != denom)
                            && numerator/(double)denom == ((numerator/10)/(double)(denom%10))) {
                        retNum*=numerator;
                        retDen*=denom;
                    }
            }


        return FractionUtil.reduceFraction(new Tuple<Long, Long>(retNum,retDen)).getValue2().toString();
    }
}
