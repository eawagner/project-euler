package practice.project.euler.problem.p90_99;


import practice.project.euler.Problem;

import java.io.BufferedReader;

import static java.lang.Double.parseDouble;
import static java.lang.Math.log;
import static practice.project.euler.util.GeneralUtil.getResource;

public class Problem99 implements Problem {
    @Override
    public String getAnswer() throws Exception {
        BufferedReader reader = getResource("problem99.txt");
        int lineNum = 0;
        int result = 0;

        double largest = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            lineNum++;
            String[] values = line.split(",");
            double toTest = parseDouble(values[1]) * log(parseDouble(values[0]));
            if (toTest > largest) {
                result = lineNum;
                largest = toTest;
            }
        }

        return Integer.toString(result);
    }
}
