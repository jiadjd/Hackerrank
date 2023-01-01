package PalindromeIndex;

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
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int palindromeIndex(String s) {
    // Write your code here
        int result = -1;
        int l = s.length();
        String reverse = new StringBuilder(s).reverse().toString();
        if(s.equals(reverse)) return -1;
        for(int i=0; i<l/2; i++) {
            if(s.charAt(i) != s.charAt(l-i-1)) {
                String s1 = s.substring(0, i) + s.substring(i+1);
                String s2 = s.substring(0, l-i-1) + s.substring(l-i);
                String r1 = new StringBuilder(s1).reverse().toString();
                String r2 = new StringBuilder(s2).reverse().toString();
                if(s1.equals(r1)) {
                    result = i;
                    break;
                } else if(s2.equals(r2)) {
                    result = l-i-1;
                    break;
                }
            }
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.palindromeIndex(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
