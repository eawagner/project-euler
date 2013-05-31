package practice.project.euler.problem;

import practice.project.euler.Problem;
import practice.project.euler.util.GeneralUtil;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

/*
In the 5 by 5 matrix below, the minimal path sum from the top left to the bottom right, by only moving to the right and down, is indicated in bold red and is equal to 2427.


131	673	234	103	18
201	96	342	965	150
630	803	746	422	111
537	699	497	121	956
805	732	524	37	331


Find the minimal path sum, in matrix.txt (right click and 'Save Link/Target As...'), a 31K text file containing a 80 by 80 matrix, from the top left to the bottom right by only moving right and down.

 */
public class Problem81 implements Problem{
    public String getAnswer() throws Exception {
        List<List<Integer>> matrix = new ArrayList<List<Integer>>(80);
        BufferedReader reader = GeneralUtil.getResource("problem81.txt");
        String line;
        while ((line = reader.readLine()) != null) {
            String[] strings = line.split(",");
            ArrayList<Integer> row = new ArrayList<Integer>(strings.length);
            for (String string : strings)
                row.add(Integer.parseInt(string));

            matrix.add(row);
        }



        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
