package NewYearChaos;

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
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        // method 1: 
        // first take out the scenario where it's too caotic
        // then, count from beginning
        // if q.get(i) < q.get(i-1)
        // swap those 2 numbers
        // after swap, if q.get(i-1) < q.get(i-2), swap again
        // continue swapping until condition is false
        int l = q.size();
        int bribes = 0;
        int temp = 0;
        for(int i=0; i<l; i++) {
            temp = q.get(i);
            if(temp - i >3) {
                System.out.println("Too chaotic");
                return;
            } else if(i>0) {
                int j = i;
                while (j>0 && q.get(j) < q.get(j-1)) {
                    q.set(j, q.get(j-1));
                    q.set(j-1, temp);
                    bribes++;
                    j--;
                }
            }
        }
        System.out.println(bribes);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
