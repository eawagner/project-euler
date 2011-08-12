package practice.project.euler.problem;

import practice.project.euler.Problem;
import practice.project.euler.util.model.Tuple;

import java.util.Arrays;
import java.util.HashMap;

/*
The cube, 41063625 (3453), can be permuted to produce two other cubes: 56623104 (3843) and 66430125 (4053). In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.

Find the smallest cube for which exactly five permutations of its digits are cube.

 */
public class Problem62 implements Problem{
    public String getAnswer() throws Exception {

        HashMap<String,Tuple<Integer,Integer>> permCount = new HashMap<String, Tuple<Integer,Integer>>();

        for (int i = 5;;i++) {
            //sort the string to group all the bytes together
            byte[] bytes = Long.toString((long)Math.pow(i,3)).getBytes();
            Arrays.sort(bytes);
            String sorted = new String(bytes);
            //if another number has the same sorted string then it is a permutation.
            if (permCount.containsKey(sorted)) {
                int currCount = permCount.get(sorted).getValue1() + 1;
                if (currCount == 5)
                    return Long.toString((long)Math.pow(permCount.get(sorted).getValue2(),3));
                permCount.put(sorted, new Tuple<Integer, Integer>(currCount, permCount.get(sorted).getValue2()));
            }
            else {
                //since we need to find the smallest we need to keep the
                permCount.put(sorted, new Tuple<Integer, Integer>(1, i));
            }


        }

    }
}
