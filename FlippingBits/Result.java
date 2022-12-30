package FlippingBits;

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
     * Complete the 'flippingBits' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long flippingBits(long n) {
    // Write your code here
        String binaryString = Long.toBinaryString(n);
        binaryString = String.format("%32s", binaryString).replace(" ", "0");
        char[] binaryChars = binaryString.toCharArray();
        for(int i=0; i<32; i++) {
            if(binaryChars[i] == '0') {
                binaryChars[i] = '1';
            } else {
                binaryChars[i] = '0';
            }
        }
        String flippedString = new String(binaryChars);
        long flippedNum = Long.parseLong(flippedString, 2);
        return flippedNum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                long result = Result.flippingBits(n);

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
