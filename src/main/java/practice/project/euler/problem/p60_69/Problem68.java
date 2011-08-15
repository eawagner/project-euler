package practice.project.euler.problem.p60_69;

import practice.project.euler.Problem;
import practice.project.euler.util.GeneralUtil;

import java.util.List;

/*
Consider the following "magic" 3-gon ring, filled with the numbers 1 to 6, and each line adding to nine.

Working clockwise, and starting from the group of three with the numerically lowest external node (4,3,2 in this example), each solution can be described uniquely. For example, the above solution can be described by the set: 4,3,2; 6,2,1; 5,1,3.

It is possible to complete the ring with four different totals: 9, 10, 11, and 12. There are eight solutions in total.
Total	Solution Set
9	4,2,3; 5,3,1; 6,1,2
9	4,3,2; 6,2,1; 5,1,3
10	2,3,5; 4,5,1; 6,1,3
10	2,5,3; 6,3,1; 4,1,5
11	1,4,6; 3,6,2; 5,2,4
11	1,6,4; 5,4,2; 3,2,6
12	1,5,6; 2,6,4; 3,4,5
12	1,6,5; 3,5,4; 2,4,6

By concatenating each group it is possible to form 9-digit strings; the maximum string for a 3-gon ring is 432621513.

Using the numbers 1 to 10, and depending on arrangements, it is possible to form 16- and 17-digit strings. What is the maximum 16-digit string for a "magic" 5-gon ring?

 */
public class Problem68 implements Problem{
    public String getAnswer() throws Exception {
        String retVal = "";
        //Looking for maximum solution with 16 digits.  This implies that all of the large number will be on the outside
        //of the magic gon.  Since we always start the sequence with the lowest of the outside sequence then no need ot
        //permutate with 6 on the outside that will be the only set that we check.
        List<List<Integer>> p1 = GeneralUtil.getPermutations(1,2,3,4,5);
        List<List<Integer>> p2 = GeneralUtil.getPermutations(7,8,9,10);

        for (int i = 0;i< p1.size();i++)
            for (int j = 0; j< p2.size();j++) {
                int[][] gon = new int[5][3];

                gon[0] = new int[]{6,p1.get(i).get(0),p1.get(i).get(1)};
                gon[1] = new int[]{p2.get(j).get(0),p1.get(i).get(1),p1.get(i).get(2)};
                gon[2] = new int[]{p2.get(j).get(1),p1.get(i).get(2),p1.get(i).get(3)};
                gon[3] = new int[]{p2.get(j).get(2),p1.get(i).get(3),p1.get(i).get(4)};
                gon[4] = new int[]{p2.get(j).get(3),p1.get(i).get(4),p1.get(i).get(0)};

                if (checkSums(gon)) {
                    String output = buildString(gon);
                    if (output.compareTo(retVal)>0)
                        retVal = output;
                }
            }


        return retVal;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private static boolean checkSums(int[][] gon) {
        int commonSum = 0;
        for (int i = 0;i<gon.length;i++) {
            int sum = 0;
            for (int j = 0;j<gon[i].length;j++) {
                sum+=gon[i][j];
            }
            if (commonSum == 0)
                commonSum = sum;
            else if(commonSum != sum)
                return false;

        }

        return true;
    }

    private static String buildString(int[][] gon) {
        StringBuilder sb = new StringBuilder(16);
        for (int i = 0;i<gon.length;i++) {
            for (int j = 0;j<gon[i].length;j++) {
                sb.append(gon[i][j]);
            }

        }
        return sb.toString();
    }
}
