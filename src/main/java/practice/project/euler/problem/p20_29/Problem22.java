package practice.project.euler.problem.p20_29;

import practice.project.euler.Problem;
import practice.project.euler.util.GeneralUtil;

import java.io.IOException;
import java.util.Arrays;

/*
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?

 */
public class Problem22 implements Problem{
    public String getAnswer() throws IOException {

        String [] names = GeneralUtil.getResource("problem22.txt").readLine().replace("\"","").split(",");
        Arrays.sort(names);
        long retVal = 0;
        for (int i = 0;i<names.length;i++)
            retVal += getScore(names[i],i+1);

        return Long.toString(retVal);

    }

    private int getScore(String name, int place){
        int sum = 0;
        for (int i = 0;i<name.length();i++)
        {
            sum += name.charAt(i)-64;
        }
        return sum * place;
    }
}
