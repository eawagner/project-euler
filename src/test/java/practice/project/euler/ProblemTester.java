package practice.project.euler;


import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import practice.project.euler.problem.p01_09.*;
import practice.project.euler.problem.p10_19.*;
import practice.project.euler.problem.p20_29.*;
import practice.project.euler.problem.p30_39.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProblemTester {


    Map<Problem,String> problemAndResults = new LinkedHashMap<Problem, String>();

    @Before
    public void init()
    {
        problemAndResults.put(new Problem1(), "233168");
        problemAndResults.put(new Problem2(), "4613732");
        problemAndResults.put(new Problem3(), "6857");
        problemAndResults.put(new Problem4(), "906609");
        problemAndResults.put(new Problem5(), "232792560");
        problemAndResults.put(new Problem6(), "25164150");
        problemAndResults.put(new Problem7(), "104743");
        problemAndResults.put(new Problem8(), "40824");
        problemAndResults.put(new Problem9(), "31875000");

        problemAndResults.put(new Problem10(), "142913828922");
        problemAndResults.put(new Problem11(), "70600674");
        problemAndResults.put(new Problem12(), "76576500");
        problemAndResults.put(new Problem13(), "5537376230");
        problemAndResults.put(new Problem14(), "837799");
        problemAndResults.put(new Problem15(), "137846528820");
        problemAndResults.put(new Problem16(), "1366");
        problemAndResults.put(new Problem17(), "21124");
        problemAndResults.put(new Problem18(), "1074");
        problemAndResults.put(new Problem19(), "171");

        problemAndResults.put(new Problem20(), "648");
        problemAndResults.put(new Problem21(), "31626");
        problemAndResults.put(new Problem22(), "871198282");
        problemAndResults.put(new Problem23(), "4179871");
        problemAndResults.put(new Problem24(), "2783915460");
        problemAndResults.put(new Problem25(), "4782");
        problemAndResults.put(new Problem26(), "983");
        problemAndResults.put(new Problem27(), "-59231");
        problemAndResults.put(new Problem28(), "669171001");
        problemAndResults.put(new Problem29(), "9183");

        problemAndResults.put(new Problem30(), "443839");
        problemAndResults.put(new Problem31(), "73682");
        problemAndResults.put(new Problem32(), "45228");
        problemAndResults.put(new Problem33(), "100");
        problemAndResults.put(new Problem34(), "40730");
        problemAndResults.put(new Problem35(), "55");
        problemAndResults.put(new Problem36(), "872187");
        problemAndResults.put(new Problem37(), "748317");
        problemAndResults.put(new Problem38(), "932718654");
        problemAndResults.put(new Problem39(), "840");
    }


    @Test
    public void testAll() throws Exception {
        long total = 0;
        for (Map.Entry<Problem,String> problems : problemAndResults.entrySet())
        {
            long startProblemTime=System.currentTimeMillis();
            Assert.assertEquals(problems.getValue(),problems.getKey().getAnswer());
            long problemRunTime=System.currentTimeMillis() - startProblemTime;
            Assert.assertTrue("Problem ran longer than 2 minutes, needs optimization", problemRunTime < 120000);

            total+=problemRunTime;

            System.out.println(problems.getKey().getClass().getSimpleName() + " ran in: " + problemRunTime);
        }
        System.out.println();
        System.out.println("Total runtime: " + total);
        System.out.println("Average runtime: " + total/problemAndResults.entrySet().size());
    }

}
