package practice.project.euler.util;

public class StringUtil {

    public static boolean isPalendrome(long number){
        return isPalendrome(Long.toString(number));
    }

    public static boolean isPalendrome(String string)
    {
        return new StringBuffer(string).reverse().toString().equals(string);
    }

    public static String reverse(String string)
    {
        return new StringBuffer(string).reverse().toString();
    }

    public static int getSumOfDigits(String number)
    {
        int sum = 0;
        for (int i = 0;i<number.length();i++) {
            sum += Integer.parseInt(number.substring(i,i+1));
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

    public static boolean isPermutation(String original, String toCheck)
    {
        for (int i = 0;i<original.length();i++)
            toCheck = toCheck.replaceFirst(Character.toString(original.charAt(i)),"");

        return toCheck.length()==0;
    }
}
