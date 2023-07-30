package RecursiveDigitSum;

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
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    public static int superDigit(String n, int k) {
    // Write your code here
        n = n.replaceAll("\\s", "");
        int result = 10;
        char[] nums = n.toCharArray();
        long sum = 0;
        for(char c: nums) {
            int value = Character.getNumericValue(c);
            sum = sum + value * k;
        }
        String s = String.valueOf(sum);
        while(sum >= 10) {
            sum = getSum(s);
            s = String.valueOf(sum);
        }
        return (int)sum;
    }
    
    private static int makeSum(String n) {
        long sum = 0;
        char[] nums = s.toCharArray();
        for(char c: nums) {
            int value = Character.getNumericValue(c);
            sum += value;
        }
        return sum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
