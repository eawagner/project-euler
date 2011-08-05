package practice.project.euler.problem.p10_19;

import practice.project.euler.Problem;

/*
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.

 */
public class Problem17 implements Problem{
    public String getAnswer() {
        int singleDigits = "one two three four five six seven eight nine".replace(" ","").length();
        int tensDigits = "ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen".replace(" ","").length();
        int twentyToNinety = "twenty thirty forty fifty sixty seventy eighty ninety".replace(" ","").length();

        /*
        tensDigits only appear once, twenty to ninety headers appear 10 times each (20-29),
        single digits appear 9 times as they are already counted in tensDigits.
         */
        int oneTo99 = tensDigits + twentyToNinety * 10 + singleDigits * 9;

        /*The terms onehundred - ninehundred appear 100 times each 100-99.
        The "and" term appears 891 times.  1000 - 100(first 99) - 9(zero case for 100,200...900).
        Finally
         */
        int oneTo999 = (singleDigits + "hundred".length() *9) * 100 + "and".length() * 891 + oneTo99 * 10;


        return Integer.toString(oneTo999+"onethousand".length());
    }

}
