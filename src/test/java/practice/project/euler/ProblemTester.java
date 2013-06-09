package practice.project.euler;


import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import practice.project.euler.problem.*;
import practice.project.euler.problem.p01_09.*;
import practice.project.euler.problem.p10_19.*;
import practice.project.euler.problem.p20_29.*;
import practice.project.euler.problem.p30_39.*;
import practice.project.euler.problem.p40_49.*;
import practice.project.euler.problem.p50_59.*;
import practice.project.euler.problem.p60_69.*;
import practice.project.euler.problem.p70_79.*;
import practice.project.euler.problem.p80_89.*;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.System.currentTimeMillis;

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

        problemAndResults.put(new Problem40(), "210");
        problemAndResults.put(new Problem41(), "7652413");
        problemAndResults.put(new Problem42(), "162");
        problemAndResults.put(new Problem43(), "16695334890");
        problemAndResults.put(new Problem44(), "5482660");
        problemAndResults.put(new Problem45(), "1533776805");
        problemAndResults.put(new Problem46(), "5777");
        problemAndResults.put(new Problem47(), "134043");
        problemAndResults.put(new Problem48(), "9110846700");
        problemAndResults.put(new Problem49(), "296962999629");

        problemAndResults.put(new Problem50(), "997651");
        problemAndResults.put(new Problem51(), "121313");
        problemAndResults.put(new Problem52(), "142857");
        problemAndResults.put(new Problem53(), "4075");
        problemAndResults.put(new Problem54(), "376");
        problemAndResults.put(new Problem55(), "249");
        problemAndResults.put(new Problem56(), "972");
        problemAndResults.put(new Problem57(), "153");
        problemAndResults.put(new Problem58(), "26241");
        problemAndResults.put(new Problem59(), "107359");

        problemAndResults.put(new Problem60(), "26033");
        problemAndResults.put(new Problem61(), "28684");
        problemAndResults.put(new Problem62(), "127035954683");
        problemAndResults.put(new Problem63(), "49");
        problemAndResults.put(new Problem64(), "1317");
        problemAndResults.put(new Problem65(), "272");
        problemAndResults.put(new Problem66(), "661");
        problemAndResults.put(new Problem67(), "7273");
        problemAndResults.put(new Problem68(), "6531031914842725");
        problemAndResults.put(new Problem69(), "510510");

        problemAndResults.put(new Problem70(), "8319823");
        problemAndResults.put(new Problem71(), "428570");
        problemAndResults.put(new Problem72(), "303963552391");
        problemAndResults.put(new Problem73(), "7295372");
        problemAndResults.put(new Problem74(), "402");
        problemAndResults.put(new Problem75(), "161667");
        problemAndResults.put(new Problem76(), "190569291");
        problemAndResults.put(new Problem77(), "71");
        problemAndResults.put(new Problem78(), "55374");
        problemAndResults.put(new Problem79(), "73162890");

        problemAndResults.put(new Problem80(), "40886");
        problemAndResults.put(new Problem81(), "427337");
        problemAndResults.put(new Problem82(), "260324");
        problemAndResults.put(new Problem83(), "425185");
        problemAndResults.put(new Problem84(), "101524");
        problemAndResults.put(new Problem85(), "2772");
        problemAndResults.put(new Problem86(), "1818");
        problemAndResults.put(new Problem87(), "1097343");
        problemAndResults.put(new Problem88(), "7587457");
        problemAndResults.put(new Problem89(), "743");

        problemAndResults.put(new Problem90(), "1217");
        problemAndResults.put(new Problem91(), "14234");
        problemAndResults.put(new Problem92(), "8581146");
        problemAndResults.put(new Problem93(), "1258");
        problemAndResults.put(new Problem94(), "518408346");
        problemAndResults.put(new Problem95(), "14316");
        problemAndResults.put(new Problem96(), "24702");

    }


    @Test
    public void testAll() throws Exception {
        long total = 0;
        for (Map.Entry<Problem,String> problems : problemAndResults.entrySet())
        {
            long startProblemTime= currentTimeMillis();
            Assert.assertEquals(problems.getValue(),problems.getKey().getAnswer());
            long problemRunTime= currentTimeMillis() - startProblemTime;
            Assert.assertTrue("Problem ran longer than 2 minutes, needs optimization", problemRunTime < 120000);

            total+=problemRunTime;

            System.out.println(problems.getKey().getClass().getSimpleName() + " ran in: " + problemRunTime);
        }
        System.out.println();
        System.out.println("Total runtime: " + total);
        System.out.println("Average runtime: " + total / problemAndResults.entrySet().size());
    }

}
