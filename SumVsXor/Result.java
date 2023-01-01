package SumVsXor;

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
     * Complete the 'sumXor' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long sumXor(long n) {
    // Write your code here
        long result = 0;
        //bitwiseXOR(21, 354);
        if(n == 0) return 1;
        for(int i=0; i<n; i++) {
            if(i + n == bitwiseXOR(i, n)) result ++;
        }
        
        
        
        return result;
    }
    
    private static long bitwiseXOR(long a, long b) {
        String sa = Long.toBinaryString(a);
        String sb = Long.toBinaryString(b);
        //if(sa.length() < sb.length()) {
        sa = String.format("%" + sb.length() + "s", sa).replace(" ", "0");

        char[] ca = sa.toCharArray();
        char[] cb = sb.toCharArray();
        char[] cf = new char[sa.length()];
        for(int i=0; i<sa.length(); i++) {
            int ia = Integer.parseInt(String.valueOf(ca[i]));
            int ib = Integer.parseInt(String.valueOf(cb[i]));
            cf[i] = (char)((ia ^ ib) + '0');
        }
        long result = Long.parseLong(new String(cf), 2);
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.sumXor(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
