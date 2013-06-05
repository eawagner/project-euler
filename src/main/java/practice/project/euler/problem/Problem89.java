package practice.project.euler.problem;


import practice.project.euler.Problem;

import java.io.BufferedReader;

import static practice.project.euler.util.GeneralUtil.getResource;

public class Problem89 implements Problem {

    @Override
    public String getAnswer() throws Exception {
        BufferedReader reader = getResource("problem89.txt");
        String line;
        int diff = 0;

        while ((line = reader.readLine()) != null)
            diff += line.length() - getMinimized(getValue(line)).length();

        return Integer.toString(diff);
    }

    private static int getValue(String numeral) {

        int sum = 0;
        int prev = Integer.MAX_VALUE;
        for (int i = 0; i< numeral.length(); i++) {
            int value = getDigitValue(numeral.charAt(i));
            if (prev < value)
                sum -= prev*2;
            sum += value;
            prev = value;
        }

        return sum;
    }

    private static String getMinimized(int value) {

        StringBuilder result = new StringBuilder();

        value = appendNumerals(value, "M", 1000, result);
        value = appendNumerals(value, "CM", 900, result);
        value = appendNumerals(value, "D", 500, result);
        value = appendNumerals(value, "CD", 400, result);
        value = appendNumerals(value, "C", 100, result);
        value = appendNumerals(value, "XC", 90, result);
        value = appendNumerals(value, "L", 50, result);
        value = appendNumerals(value, "XL", 40, result);
        value = appendNumerals(value, "X", 10, result);
        value = appendNumerals(value, "IX", 9, result);
        value = appendNumerals(value, "V", 5, result);
        value = appendNumerals(value, "IV", 4, result);
        appendNumerals(value, "I", 1, result);

        return result.toString();
    }

    private static int appendNumerals(int value, String numeral,int tocheck, StringBuilder sb) {
        while (value >= tocheck) {
            value -= tocheck;
            sb.append(numeral);
        }
        return value;
    }

    private static int getDigitValue(char digit) {
        switch (digit) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        throw new IllegalArgumentException();
    }

}
