package practice.project.euler.problem.p90_99;

/*
By replacing each of the letters in the word CARE with 1, 2, 9, and 6 respectively, we form a square number: 1296 = 362. What is remarkable is that, by using the same digital substitutions, the anagram, RACE, also forms a square number: 9216 = 962. We shall call CARE (and RACE) a square anagram word pair and specify further that leading zeroes are not permitted, neither may a different letter have the same digital value as another letter.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, find all the square anagram word pairs (a palindromic word is NOT considered to be an anagram of itself).

What is the largest square number formed by any member of such a pair?

NOTE: All anagrams formed must be contained in the given text file.
 */

import practice.project.euler.Problem;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static java.lang.Math.max;
import static java.util.Arrays.sort;
import static practice.project.euler.util.GeneralUtil.getResource;
import static practice.project.euler.util.GeneralUtil.isSquare;
import static practice.project.euler.util.StringUtil.intToChar;

public class Problem98 implements Problem {
    @Override
    public String getAnswer() throws Exception {
        String[] words = getResource("problem98.txt").readLine().replace("\"", "").split(",");
        Map<String, List<String>> groups = new LinkedHashMap<String, List<String>>();

        for (String word : words) {
            byte[] chars = word.getBytes();
            sort(chars);
            String sorted = new String(chars);
            if (!groups.containsKey(sorted))
                groups.put(sorted, new ArrayList<String>());

            groups.get(sorted).add(word);
        }

        int result = 0;
        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
            //Has to be greater than one to have a pair
            if (entry.getValue().size() > 1) {
                result = max(result, maxSquare(entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));

            }
        }

        return Integer.toString(result);
    }

    private static int maxSquare (String letters, String word1, String word2) {
        if (letters.length() == 0) {
            int value1 = parseInt(word1);
            if (!isSquare(value1))
                return 0;
            int value2 = parseInt(word2);
            if (!isSquare(value2))
                return 0;

            return max(value1, value2);
        }

        //get first char and remove it from letters.
        char letter = letters.charAt(0);
        letters = letters.replaceAll(String.valueOf(letter), ""); //also removes duplicates

        int result = 0;
        for (int i = 1; i < 10; i++) {
            char digit = intToChar(i);
            if (word1.indexOf(digit) < 0)
                result = max(result, maxSquare(letters, word1.replace(letter, digit), word2.replace(letter, digit)));
        }
        return result;
    }
}
