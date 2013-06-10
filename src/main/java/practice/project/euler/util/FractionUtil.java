package practice.project.euler.util;

import practice.project.euler.util.model.Tuple;

import static practice.project.euler.util.FactorUtil.gcd;

public class FractionUtil {


    public static Tuple<Long,Long> reduceFraction(Tuple<Long,Long> fraction) {
        long numerator = fraction.getValue1();
        long denominator = fraction.getValue2();

        long gcd = gcd(numerator, denominator);

        return new Tuple<Long, Long>(numerator/gcd,denominator/gcd);
    }

    public static Tuple<Long,Long> add(Tuple<Long,Long> fraction1, Tuple<Long,Long> fraction2) {
        return new Tuple<Long, Long>(
                fraction1.getValue1() * fraction2.getValue2() + fraction2.getValue1() * fraction1.getValue2(),
                fraction1.getValue2() * fraction2.getValue2());
    }

    public static Tuple<Long,Long> add(Tuple<Long,Long> fraction, long num) {
        return new Tuple<Long, Long>(
                fraction.getValue1() + num * fraction.getValue2(),
                fraction.getValue2());
    }

    public static Tuple<Long,Long> invert(Tuple<Long,Long> fraction) {
        return new Tuple<Long, Long>(fraction.getValue2(), fraction.getValue1());
    }

}
