package Pangrams;

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
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
    // Write your code here
        // lowercase letters ascii range is 97 - 122
        s = s.toLowerCase().replace(" ", "");
        String result = "not pangram";
        char[] chars = s.toCharArray();
        List<Integer> letters = new ArrayList<Integer>();
        for(int i=97; i<=122; i++) {
            letters.add(i);
        }
        int asciiValue = 0;
        for(int i=0; i< s.length(); i++) {
            asciiValue = (int) chars[i];
            if(letters.contains(asciiValue)) {
               letters.remove(letters.indexOf(asciiValue));
            }
        }
        if(letters.size()==0) result = "pangram";
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
