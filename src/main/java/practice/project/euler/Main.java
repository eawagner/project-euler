package practice.project.euler;

import practice.project.euler.problem.*;


public class Main {

    public static void main(String[] args){

        Problem problem = new Problem83();
        long startTime=System.currentTimeMillis();
        try {
            System.out.println(problem.getAnswer());

        } catch (Throwable th)
        {
            System.out.println("Error: "+th.getMessage());
            th.printStackTrace();
        }
        long runTime=System.currentTimeMillis()-startTime;

        System.out.println("TotalRuntime: "+ runTime);

    }
}
