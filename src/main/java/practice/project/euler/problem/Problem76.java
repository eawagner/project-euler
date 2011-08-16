package practice.project.euler.problem;

import practice.project.euler.Problem;
import practice.project.euler.util.GeneralUtil;
import practice.project.euler.util.PolygonUtil;

import java.util.HashMap;
import java.util.Map;

/*
It is possible to write five as a sum in exactly six different ways:

4 + 1
3 + 2
3 + 1 + 1
2 + 2 + 1
2 + 1 + 1 + 1
1 + 1 + 1 + 1 + 1

How many different ways can one hundred be written as a sum of at least two positive integers?

 */
public class Problem76 implements Problem{
    public String getAnswer() throws Exception {

        Map<Long,Long> cache = new HashMap<Long, Long>(100);


        return Long.toString(GeneralUtil.getNumParitions(100, cache)-1);
    }



}
