package practice.project.euler.problem.p10_19;

import practice.project.euler.Problem;
import practice.project.euler.util.GeneralUtil;
import practice.project.euler.util.model.Tuple;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)

 */
public class Problem18 implements Problem{
    public String getAnswer() {
        return solveMaxSum("problem18.txt");
    }

    public static String solveMaxSum(String resourceFile)
    {
        List<List<Tuple<Long,Long>>> cache = new ArrayList<List<Tuple<Long,Long>>>();

        try {

            BufferedReader reader = GeneralUtil.getResource(resourceFile);
            String line;
            while ((line = reader.readLine())!=null)
            {

                String[] numbers = line.split(" ");
                List<Tuple<Long,Long>> row = new ArrayList<Tuple<Long,Long>>(numbers.length);
                for (String number : numbers)
                    row.add(new Tuple<Long, Long>(Long.parseLong(number),0L));

                cache.add(row);
            }
            reader.close();
        } catch (IOException e) {
            return "";
        }

        return Long.toString(getMaxSum(0, 0, cache));
    }

    private static long getMaxSum(int row, int idx, List<List<Tuple<Long,Long>>> cache)
    {
        if (row >= cache.size())
            return 0;
        long currVal = cache.get(row).get(idx).getValue1();

        long left = getMaxSum(row +1, idx, cache) ;
        long right = getMaxSum(row +1, idx+1, cache) ;

        if (left > right)
            currVal += left;
        else
            currVal += right;

        cache.get(row).get(idx).setValue2(currVal);

        return currVal;

    }
}
