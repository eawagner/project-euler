package practice.project.euler.problem.p30_39;

import practice.project.euler.Problem;

import static practice.project.euler.util.StringUtil.isPandigital;

/*
Take the number 192 and multiply it by each of 1, 2, and 3:

    192 × 1 = 192
    192 × 2 = 384
    192 × 3 = 576

By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)

The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).

What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?

 */
public class Problem38 implements Problem{
    public String getAnswer() throws Exception {

        String retVal = "";

        // For the upper limit I used the following logic:
        //Since n > 1 there the pandigital must be made up from atleast two numbers. For a
        //9 digit number this leaves at worst a 4 and 5 digit number where the 4 digit will
        //be from when n = 1.  Therefore at a max you only need to test up to the set of 4 digit numbers.
        for (int i = 1;i<10000;i++) {
            String pandig = Integer.toString(i);

            for (int n = 2;;n++) {
                pandig += Integer.toString(i*n);

                if (pandig.length() > 9)
                    break;

                if (isPandigital(pandig)) {
                    if (pandig.compareTo(retVal)>0)
                        retVal = pandig;

                    break;
                }
            }
        }

        return retVal;
    }
}
