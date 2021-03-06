package practice.project.euler.problem.p20_29;

import practice.project.euler.Problem;

/*
Consider all integer combinations of ab for 2 ≤ a ≤ 5 and 2 ≤ b ≤ 5:

    22=4, 23=8, 24=16, 25=32
    32=9, 33=27, 34=81, 35=243
    42=16, 43=64, 44=256, 45=1024
    52=25, 53=125, 54=625, 55=3125

If they are then placed in numerical order, with any repeats removed, we get the following sequence of 15 distinct terms:

4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125

How many distinct terms are in the sequence generated by ab for 2 ≤ a ≤ 100 and 2 ≤ b ≤ 100?

 */
public class Problem29 implements Problem{
    public String getAnswer() throws Exception {
        int retVal = 0;
        boolean [][] duplicates = new boolean[101][101];

        //Too avoid using big ints, I simply mark duplicates

        for (int a = 2; a<= 100; a++) {
            int power = a*a;
            for (int b = 2; power<= 100; b++) {
                for (int i = 2;i<b*100;i++)
                    if (i%b == 0)
                    {
                        int d = i/b;
                        if (d<=100 && hasLowerDivisor(i,b))
                            duplicates[power][d] =true;
                    }
                power*=a;
            }
        }

        for (int i = 2;i < duplicates.length; i++)
            for (int j = 2; j<duplicates[i].length; j++)
                if (!duplicates[i][j])
                    retVal++;

        return Integer.toString(retVal);
    }

    private boolean hasLowerDivisor(int a, int b)
    {
        for (int i = 1; i<b; i++)
            if (a%i == 0 && a/i <=100) return true;

        return false;
    }
}
