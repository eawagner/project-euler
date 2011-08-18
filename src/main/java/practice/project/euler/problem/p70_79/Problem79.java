package practice.project.euler.problem.p70_79;

import practice.project.euler.Problem;
import practice.project.euler.util.GeneralUtil;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
A common security method used for online banking is to ask the user for three random characters from a passcode. For example, if the passcode was 531278, they may ask for the 2nd, 3rd, and 5th characters; the expected reply would be: 317.

The text file, keylog.txt, contains fifty successful login attempts.

Given that the three characters are always asked for in order, analyse the file so as to determine the shortest possible secret passcode of unknown length.

 */
public class Problem79 implements Problem{
    public String getAnswer() throws Exception {
        List<String> nums = new ArrayList<String>();
        BufferedReader reader = GeneralUtil.getResource("problem79.txt");
        String line;
        String retVal = "";
        while ((line = reader.readLine()) != null)
            nums.add(line);

        while (nums.size() > 0) {
            String cand = null;
            int i = 0;
            do {
                cand = nums.get(i).substring(0,1);
                i++;
            } while (checkLater(cand,nums));

            retVal+=cand;

            nums = removeCand(cand,nums);
        }

        return retVal;
    }

    private static boolean checkLater(String toCheck, Collection<String> nums) {

        for (String num : nums) {
            if (num.length() > 1 && num.indexOf(toCheck)>0)
                return true;
        }
        return false;
    }

    private static List<String> removeCand(String cand, List<String> nums) {

        List<String> retVal = new ArrayList<String>(nums.size());

        for (String num : nums) {
            num = num.replace(cand,"");
            if (!num.equals(""))
                retVal.add(num);
        }

        return retVal;
    }




}
