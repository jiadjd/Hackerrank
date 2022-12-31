package SherlockAndArray;

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
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String balancedSums(List<Integer> arr) {
    // Write your code here
        int l = arr.size();
        int m = l/2;
        String result = "NO";
        int sumLeft = 0;
        int sumRight = 0;
        for(int i=0; i<m; i++) {
            sumLeft += arr.get(i);
        }
        for(int i=m+1; i<l; i++) {
            sumRight += arr.get(i);
        }
        int startL = m-1;
        int startR = m+1;
        if(sumLeft == sumRight) {
            result = "YES";
            return result;
        } else if(sumLeft > sumRight) {
            while (sumLeft > sumRight && startL >= 0) {
                sumLeft -= arr.get(startL);
                sumRight += arr.get(startL+1);
                startL--;
            }
        } else {
            while (sumLeft < sumRight && startR <= l) {
                sumLeft += arr.get(startR-1);
                sumRight -= arr.get(startR);
                startR ++;
            }
        }
        if(sumLeft == sumRight) {
            result = "YES";
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = Result.balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
