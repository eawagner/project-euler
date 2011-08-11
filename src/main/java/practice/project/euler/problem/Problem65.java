package practice.project.euler.problem;

import practice.project.euler.Problem;
import practice.project.euler.util.FractionUtil;
import practice.project.euler.util.model.Tuple;

/*
The square root of 2 can be written as an infinite continued fraction.
√2 = 1 +
1

  	2 +
1

  	  	2 +
1

  	  	  	2 +
1

  	  	  	  	2 + ...

The infinite continued fraction can be written, √2 = [1;(2)], (2) indicates that 2 repeats ad infinitum. In a similar way, √23 = [4;(1,3,1,8)].

It turns out that the sequence of partial values of continued fractions for square roots provide the best rational approximations. Let us consider the convergents for √2.
1 +
1

	= 3/2

2

1 +
1

	= 7/5
  	2 +
1


2

1 +
1

	= 17/12
  	2 +
1


  	  	2 +
1



2

1 +
1

	= 41/29
  	2 +
1

  	  	2 +
1


  	  	  	2 +
1



2


Hence the sequence of the first ten convergents for √2 are:
1, 3/2, 7/5, 17/12, 41/29, 99/70, 239/169, 577/408, 1393/985, 3363/2378, ...

What is most surprising is that the important mathematical constant,
e = [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...].

The first ten terms in the sequence of convergents for e are:
2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...

The sum of digits in the numerator of the 10th convergent is 1+4+5+7=17.

Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.

 */
public class Problem65 implements Problem{
    public String getAnswer() throws Exception {

        Tuple<Long,Long> fraction = new Tuple<Long, Long>(0L,1L);
        for (int i = 99;i>0;i--)
        {
            if (i%3 == 2) {
                fraction = FractionUtil.add(fraction,i/3 + 1);
            } else
                fraction = FractionUtil.add(fraction,1);

            fraction = FractionUtil.invert(fraction);
        }

        fraction = FractionUtil.add(fraction,2);


        return Long.toString(fraction.getValue1());
    }
}
