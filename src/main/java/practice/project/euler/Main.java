package practice.project.euler;

import practice.project.euler.problem.*;
import practice.project.euler.problem.p01_09.Problem9;
import practice.project.euler.problem.p30_39.Problem31;
import practice.project.euler.problem.p30_39.Problem39;


public class Main {

    public static void main(String[] args){

        Problem problem = new Problem77();
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
