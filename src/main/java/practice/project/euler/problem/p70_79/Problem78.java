package practice.project.euler.problem.p70_79;

import practice.project.euler.Problem;

import static practice.project.euler.util.PolygonUtil.genPolyagonalNum;

/*
Let p(n) represent the number of different ways in which n coins can be separated into piles. For example, five coins can separated into piles in exactly seven different ways, so p(5)=7.
OOOOO
OOOO   O
OOO   OO
OOO   O   O
OO   OO   O
OO   O   O   O
O   O   O   O   O

Find the least value of n for which p(n) is divisible by one million.

 */
public class Problem78 implements Problem{

    public String getAnswer() throws Exception {
        int[] parts = new int[1000000];
        parts[0] = 1;
		int num = 1;
		while(parts[num-1]%1000000 != 0){
			int x = 1;
			int i = 1;
			parts[num] = 0;

			while(genPolyagonalNum(5, x) <= num){
				parts[num] = parts[num] + parts[num - (int) genPolyagonalNum(5, x)]*sign(i);
				parts[num] = parts[num] % 1000000;
				if(x > 0) x = -x;
				else x = (-x) + 1;
				i++;
			}
			num++;
		}
        return Integer.toString(num-1);
    }

    private static int sign(int k){
		return (k+1 & 2) - 1;
	}

}
