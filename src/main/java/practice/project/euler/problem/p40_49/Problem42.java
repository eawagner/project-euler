package practice.project.euler.problem.p40_49;

import practice.project.euler.Problem;

import static practice.project.euler.util.GeneralUtil.getResource;
import static practice.project.euler.util.PolygonUtil.isPolyagonalNumber;

/*
The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?

 */
public class Problem42 implements Problem{
    public String getAnswer() throws Exception {
        String[] names = getResource("problem42.txt").readLine().replace("\"","").split(",");
        int retVal = 0;
        for (String name : names) {
            int sum = 0;
            for (int i = 0;i<name.length();i++)
                sum+=name.charAt(i)-64;

            if (isPolyagonalNumber(3, sum))
                retVal++;

        }

        return Integer.toString(retVal);
    }


}
