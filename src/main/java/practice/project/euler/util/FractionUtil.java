package practice.project.euler.util;

import practice.project.euler.util.model.Tuple;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ewagner
 * Date: 8/11/11
 * Time: 5:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class FractionUtil {


    public static Tuple<Long,Long> reduceFraction(Tuple<Long,Long> fraction) {
        long numerator = fraction.getValue1();
        long denominator = fraction.getValue2();

        long gcd = FactorUtil.gcd(numerator, denominator);

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
