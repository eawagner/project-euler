package practice.project.euler.util.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;
import static java.util.Arrays.asList;

public class ContinuedFraction {

    List<Long> frac;
    int periodStart = -1;


    public ContinuedFraction(Long... frac) {
        this.frac = asList(frac);

    }

    public ContinuedFraction(List<Long> frac) {
        this(-1,frac);
    }

    public ContinuedFraction(int periodStart, List<Long> frac) {
        this.periodStart = periodStart;
        this.frac = frac;
    }

    public List<Long> getFrac() {
        return frac;
    }

    public void setFrac(List<Long> frac) {
        this.frac = frac;
    }

    public int getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(int periodStart) {
        this.periodStart = periodStart;
    }

    public int getPeriodLength() {
        if (periodStart < 0)
            return -1;

        return (frac.size() - periodStart);
    }

    public long get(int n) {

        if (n< frac.size())
            return frac.get(n);

        n -= periodStart;
        n %= getPeriodLength();
        return frac.get(periodStart + n);
    }

    public Fraction expand(int n) {

        if (n<1)
            return new Fraction(get(0),1);

        BigInteger p2 = valueOf(get(0));
        BigInteger p1 = p2.multiply(valueOf(get(1))).add(ONE);
        BigInteger p = p1;

        BigInteger q2 = ONE;
        BigInteger q1 = valueOf(get(1));
        BigInteger q = q1;

        for (int i = 2;i<=n;i++) {
            p = valueOf(get(i)).multiply(p1).add(p2);
            p2=p1;
            p1=p;

            q = valueOf(get(i)).multiply(q1).add(q2);
            q2=q1;
            q1=q;
        }


        return new Fraction(p,q);
    }




    public static ContinuedFraction fromSquareRoot(long d) {
        double tmp = sqrt(d);
        if (tmp == (long)tmp)
            return new ContinuedFraction((long)tmp);

        List<Long> frac = new ArrayList<Long>();

        long a0 = (long)tmp;
        long d0 = 1;
        long m0 = 0;
        long mn = m0;
        long dn = d0;
        long an = a0;

        frac.add(a0);
        do {
            mn = dn * an - mn;
            dn = (d - mn * mn) / dn;
            an = (a0 + mn) / dn;
            frac.add(an);
        } while(dn != 1);

        return new ContinuedFraction(1, frac);
    }

}
