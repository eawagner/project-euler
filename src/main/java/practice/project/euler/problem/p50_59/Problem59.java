package practice.project.euler.problem.p50_59;

import practice.project.euler.Problem;
import practice.project.euler.util.GeneralUtil;
import practice.project.euler.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Each character on a computer is assigned a unique code and the preferred standard is ASCII (American Standard Code for Information Interchange). For example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.

A modern encryption method is to take a text file, convert the bytes to ASCII, then XOR each byte with a given value, taken from a secret key. The advantage with the XOR function is that using the same encryption key on the cipher text, restores the plain text; for example, 65 XOR 42 = 107, then 107 XOR 42 = 65.

For unbreakable encryption, the key is the same length as the plain text message, and the key is made up of random bytes. The user would keep the encrypted message and the encryption key in different locations, and without both "halves", it is impossible to decrypt the message.

Unfortunately, this method is impractical for most users, so the modified method is to use a password as a key. If the password is shorter than the message, which is likely, the key is repeated cyclically throughout the message. The balance for this method is using a sufficiently long password key for security, but short enough to be memorable.

Your task has been made easy, as the encryption key consists of three lower case characters. Using cipher1.txt (right click and 'Save Link/Target As...'), a file containing the encrypted ASCII codes, and the knowledge that the plain text must contain common English words, decrypt the message and find the sum of the ASCII values in the original text.

 */
public class Problem59 implements Problem{
    public String getAnswer() throws Exception {

        String [] input = GeneralUtil.getResource("problem59.txt").readLine().split(",");
        int[] letters = new int[input.length];
        int[] key = new int[3];
        List<Map<Integer,Integer>> freqAnalysis = new ArrayList<Map<Integer,Integer>>(key.length);
        int retVal = 0;


        for (int i = 0;i<key.length;i++)
            freqAnalysis.add(new HashMap<Integer, Integer>());

        for (int i = 0;i<input.length;i++)
        {
            Map<Integer,Integer> set = freqAnalysis.get(i % freqAnalysis.size());
            Integer letter = new Integer(input[i]);
            letters[i] = letter;
            if (set.containsKey(letter))
                set.put(letter, set.get(letter) + 1);
            else
                set.put(letter,1);
        }

        for (int i = 0;i<key.length;i++) {
            int mostFrequent = 0;
            int maxFound = 0;
            for (Map.Entry<Integer, Integer> frequency : freqAnalysis.get(i).entrySet())
                if (frequency.getValue() > maxFound) {
                    mostFrequent = frequency.getKey();
                    maxFound = frequency.getValue();
                }

            //find character that will make most frequent.
            for (int j = 97;i<123;j++)
            {
                //Looking for the most frequent character to be a space.  otherwise look for e.
                if ((j^mostFrequent) == 32) {
                    key[i] = j;
                    break;
                }
            }
        }

        for (int i = 0;i<letters.length;i++)
            retVal += (letters[i] ^ key[i%key.length]);

        return Integer.toString(retVal);
    }
}
