package practice.project.euler.util;

import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.sort;

public class StringUtil {

    public static boolean isPalendrome(long number){
        return isPalendrome(Long.toString(number));
    }

    public static boolean isPalendrome(String string)
    {
        return reverse(string).equals(string);
    }

    public static String reverse(String string)
    {
        return new StringBuffer(string).reverse().toString();
    }

    public static int getSumOfDigits(String number)
    {
        int sum = 0;
        for (int i = 0;i<number.length();i++) {
            sum += parseInt(number.substring(i, i + 1));
        }
        return sum;
    }

    public static boolean isPandigital(String number)
    {
        if (number.length() > 9)
            return false;

        for (int i = 1;i<=number.length();i++)
            if(!number.contains(Integer.toString(i)))
                return false;

        return true;
    }

    public static int charToInt(char character) {
        return character - 48;
    }

    public static char intToChar(int value) {
        return (char)(value + 48);
    }

    public static boolean isPermutation(String original, String toCheck)
    {
        byte [] origBytes = original.getBytes();
        sort(origBytes);
        byte [] checkBytes = toCheck.getBytes();
        sort(checkBytes);
        return Arrays.equals(origBytes, checkBytes);

    }
}
