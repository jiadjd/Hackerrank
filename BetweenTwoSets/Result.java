package BetweenTwoSets;

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
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
        int result = 0;
        int la = a.size();
        int lb = b.size();
        Collections.sort(a);
        Collections.sort(b);
        int min = a.get(la-1);
        int max = b.get(0);
        List<Integer> nums = new ArrayList<Integer>();
        int m = min;
        int i=1;
        while(m<max) {
            m = min * i;
            nums.add(m);
            i++;
        }
        boolean satisfy1 = true;
        boolean satisfy2 = true;
        for(int q=0; q<nums.size(); q++) {
            int w = 0;
            while(satisfy1 && w<la) {
                if(nums.get(q) % a.get(w) == 0) {
                    w++;
                } else {
                    satisfy1 = false;
                } 
            }
            int e = 0;
            while(satisfy2 && e<lb) {
                if(b.get(e) % nums.get(q) == 0) {
                    e++;
                } else {
                    satisfy2 = false;
                } 
            }
            if(satisfy1 && satisfy2) {
                result++;
            }
            satisfy1 = true;
            satisfy2 = true;
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
