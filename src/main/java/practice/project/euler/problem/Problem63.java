package practice.project.euler.problem;

import practice.project.euler.Main;
import practice.project.euler.Problem;

/*
The 5-digit number, 16807=75, is also a fifth power. Similarly, the 9-digit number, 134217728=89, is a ninth power.

How many n-digit positive integers exist which are also an nth power?
*/
public class Problem63 implements Problem{
    public String getAnswer() throws Exception {


        int sum = 0;

        for (int i = 1;i<10;i++)
            sum+= (int) (1.0/(1-Math.log(i)/Math.log(10)));



        return Integer.toString(sum);
    }
}