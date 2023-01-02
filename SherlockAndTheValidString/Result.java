package SherlockAndTheValidString;

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
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
    // Write your code here
        String result = "NO";
        Map<Character, Integer> times = new HashMap<>();
        for(char c: s.toCharArray()) {
            if(times.containsKey(c)) {
                times.put(c, times.get(c) + 1);
            } else {
                times.put(c, 1);
            }
        }
        List<Integer> t = new ArrayList<>(times.values());
        Collections.sort(t);
        int p = t.size();
        if(p < 2) {
            return "YES";
        }
        int max = t.get(p-1);
        int min = t.get(0);
        int minNext = t.get(1);
        int maxNext = t.get(p-2);
        if(min == max) {
            result = "YES";
        } else if(min == 1 && minNext == max) {
            result = "YES";
        } else if(max == min + 1 && min == maxNext) {
            result = "YES";
        } 
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
