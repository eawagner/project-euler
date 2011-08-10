package practice.project.euler;

import practice.project.euler.problem.*;
import practice.project.euler.problem.p40_49.Problem42;


public class Main {

    public static void main(String[] args){

        Problem problem = new Problem42();
        long startTime=System.currentTimeMillis();
        try {
            System.out.println(problem.getAnswer());

        } catch (Throwable th)
        {
            System.out.println("Error: "+th.getMessage());
        }
        long runTime=System.currentTimeMillis()-startTime;

        System.out.println("TotalRuntime: "+ runTime);

    }
}
