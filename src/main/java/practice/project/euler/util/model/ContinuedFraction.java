package practice.project.euler.util.model;

import com.sun.org.apache.regexp.internal.REUtil;
import sun.security.pkcs11.P11TlsKeyMaterialGenerator;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: ewagner
 * Date: 8/15/11
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class ContinuedFraction {

    List<Long> frac;
    int periodStart = -1;


    public ContinuedFraction(long... frac)
    {
        this.frac = new ArrayList<Long>(frac.length);
        for (long num : frac)
            this.frac.add(num);

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

        BigInteger p2 = BigInteger.valueOf(get(0));
        BigInteger p1 = p2.multiply(BigInteger.valueOf(get(1))).add(BigInteger.ONE);
        BigInteger p = p1;

        BigInteger q2 = BigInteger.ONE;
        BigInteger q1 = BigInteger.valueOf(get(1));
        BigInteger q = q1;

        for (int i = 2;i<=n;i++) {
            p = BigInteger.valueOf(get(i)).multiply(p1).add(p2);
            p2=p1;
            p1=p;

            q = BigInteger.valueOf(get(i)).multiply(q1).add(q2);
            q2=q1;
            q1=q;
        }


        return new Fraction(p,q);
    }




    public static ContinuedFraction fromSquareRoot(long d) {
        double tmp = Math.sqrt(d);
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
