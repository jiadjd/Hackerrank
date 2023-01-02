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

class Result1 {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        // method 2: 
        // count from end to beginning
        // if q.get(i) != i+1, 
        // check if q.get(i-1) == i+1;
            // if yes. swap once, bribes ++;
            // if not, check if q.get(i-2) == i+1;
                // if yes, swap twice, bribes += 2;
                // if not, too chaotic
        // continue until reach i=0;
        int l = q.size();
        int bribes = 0;
        int temp = 0;
        for(int i=l-1; i>=0; i--) {
            if(q.get(i) != i+1) {
                temp = q.get(i);
                if(q.get(i-1) == i+1) {
                    q.set(i, q.get(i-1));
                    q.set(i-1, temp);
                    bribes += 1;
                } else if(q.get(i-2) == i+1){
                    q.set(i, q.get(i-2));
                    q.set(i-2, q.get(i-1));
                    q.set(i-1, temp);
                    bribes += 2;
                } else {
                    System.out.println("Too chaotic");
                    return;
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
