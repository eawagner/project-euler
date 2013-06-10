package practice.project.euler.problem;


import practice.project.euler.Problem;
import practice.project.euler.util.model.Tuple;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static practice.project.euler.util.GeneralUtil.getResource;

public class Problem102 implements Problem {

    private static final Tuple<Integer, Integer> ORIGIN = new Tuple<Integer, Integer>(0,0);

    @Override
    public String getAnswer() throws Exception {
        BufferedReader reader = getResource("problem102.txt");
        List<Tuple<Integer, Integer>> triangle = new ArrayList<Tuple<Integer, Integer>>(3);
        String line;
        int result = 0;
        while ((line = reader.readLine()) != null) {
            String[] numbers = line.split(",");

            triangle.clear();
            for (int i = 0; i < 3;i ++)
                triangle.add(new Tuple<Integer, Integer>(parseInt(numbers[i * 2]), parseInt(numbers[i * 2 + 1])));


            int area = doubleArea(triangle.get(0), triangle.get(1), triangle.get(2));
            int combined = doubleArea(ORIGIN, triangle.get(1), triangle.get(2)) +
                    doubleArea(triangle.get(0), ORIGIN, triangle.get(2)) +
                    doubleArea(triangle.get(0), triangle.get(1), ORIGIN);

            if (area == combined)
                result++;
        }

        return Integer.toString(result);
    }

    /*
     * Uses the following equation for the area Area= abs(x1*y2 + x2*y3 + x3*y1 - x1*y3 - x3*y2 - x2*y1)/2.
     * However by removing the division by 2 you can keep it integer only as long as you only compare it to a value
     * that has done the same thing.
     */
    private static int doubleArea(Tuple<Integer, Integer> p1, Tuple<Integer, Integer> p2, Tuple<Integer, Integer> p3) {

        //Area= abs(x1*y2 + x2*y3 + x3*y1 - x1*y3 - x3*y2 - x2*y1)/2
        return abs(p1.getValue1() * p2.getValue2() +
                p2.getValue1() * p3.getValue2() +
                p3.getValue1() * p1.getValue2() -
                p1.getValue1() * p3.getValue2() -
                p3.getValue1() * p2.getValue2() -
                p2.getValue1() * p1.getValue2());

    }
}
