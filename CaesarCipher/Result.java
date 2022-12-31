package CaesarCipher;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
    // Write your code here
        int l = s.length();
        char[] charA = s.toCharArray();
        char[] charB = new char[l];
        
        for(int i=0; i<l; i++) {
            charB[i] = shiftLetters(charA[i], k);
        }
        String result = new String(charB);
        return result;
    }
    
    // uppercase letters (A - Z): 65 - 90
    // lowercase letters (a - z): 97 - 122
    private static char shiftLetters(char c, int k) {
        int asciiValue = (int) c;
        if(asciiValue >= 65 && asciiValue <= 90) {
            asciiValue += k;
            if(asciiValue > 90) {
                while (asciiValue > 90) {
                    asciiValue -=26;
                }
            }
        } else if (asciiValue >= 97 && asciiValue <= 122) {
            asciiValue += k;
            if(asciiValue > 122) {
                while (asciiValue > 122) {
                    asciiValue -= 26;
                }
            }
        }
        char result = (char) asciiValue;
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
