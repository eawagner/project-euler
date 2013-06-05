package practice.project.euler;

import practice.project.euler.problem.Problem86;

import static java.lang.System.currentTimeMillis;


public class Main {

    public static void main(String[] args){

        Problem problem = new Problem86();
        long startTime= currentTimeMillis();
        try {
            System.out.println(problem.getAnswer());

        } catch (Throwable th)
        {
            System.out.println("Error: "+th.getMessage());
            th.printStackTrace();
        }
        long runTime= currentTimeMillis()-startTime;

        System.out.println("TotalRuntime: "+ runTime);

    }
}
