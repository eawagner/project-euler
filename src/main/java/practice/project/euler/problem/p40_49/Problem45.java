package practice.project.euler.problem.p40_49;

import practice.project.euler.Problem;
import practice.project.euler.util.PolygonUtil;

import static practice.project.euler.util.PolygonUtil.genPolyagonalNum;

/*
Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:
Triangle 	  	Tn=n(n+1)/2 	  	1, 3, 6, 10, 15, ...
Pentagonal 	  	Pn=n(3n−1)/2 	  	1, 5, 12, 22, 35, ...
Hexagonal 	  	Hn=n(2n−1) 	  	1, 6, 15, 28, 45, ...

It can be verified that T285 = P165 = H143 = 40755.

Find the next triangle number that is also pentagonal and hexagonal.

 */
public class Problem45 implements Problem{
    public String getAnswer() throws Exception {

        for (int i = 144;;i++) {
            long hexagonal = genPolyagonalNum(6, i);
            //No need to check triangle numbers since all hex numbers are also triangle numbers
            if (PolygonUtil.isPolyagonalNumber(5, hexagonal))
                return Long.toString(hexagonal);

        }
    }
}
