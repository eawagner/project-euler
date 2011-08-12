package practice.project.euler.util.model;

import java.math.BigInteger;

public class Fraction {

    BigInteger numerator;
    BigInteger denominator;

    public Fraction(BigInteger numerator, BigInteger denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(long numerator, long denominator) {
        this.numerator = new BigInteger(Long.toString(numerator));
        this.denominator = new BigInteger(Long.toString(denominator));
    }

    public Fraction add(Fraction fraction2) {
        return new Fraction(
                getNumerator().multiply(fraction2.getDenominator()).add(fraction2.getNumerator().multiply(getDenominator())),
                getDenominator().multiply(fraction2.getDenominator()));
    }

    public Fraction add(BigInteger num) {
        return new Fraction(
                getNumerator().add(num.multiply(getDenominator())),
                getDenominator());
    }

    public Fraction add(long num) {
        return add(new BigInteger(Long.toString(num)));
    }

    public Fraction invert() {
        return new Fraction(getDenominator(), getNumerator());
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public void setNumerator(BigInteger numerator) {
        this.numerator = numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public void setDenominator(BigInteger denominator) {
        this.denominator = denominator;
    }
}
