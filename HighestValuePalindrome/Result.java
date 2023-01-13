package HighestValuePalindrome;

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
     * Complete the 'highestValuePalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER n
     *  3. INTEGER k
     */

    public static String highestValuePalindrome(String s, int n, int k) {
    // Write your code here
        char[] arr = s.toCharArray();
        int[] changes = new int[n];
        for(int i=0; i<n/2; i++) {
            if(arr[i] != arr[n-i-1]) {
                if((int)arr[i] > (int)arr[n-i-1]) {
                    arr[n-i-1] = arr[i];
                } else {
                    arr[i] = arr[n-i-1];
                }
                changes[i] = 1;
                k--;             
            }
            if(k<0) return "-1";
        }
        
        for(int i=0; i<(n+1)/2; i++) {
            int cost = 0;
            if(arr[i] != '9') {
                if(i == n-1-i || changes[i] == 1) {
                    cost = 1;
                } else {
                    cost = 2;
                }
                if(k >= cost) {
                    arr[i] = '9';
                    arr[n-i-1] = '9';
                    k-=cost;
                }
            }
        }
        return new String(arr);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String s = bufferedReader.readLine();

        String result = Result.highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
