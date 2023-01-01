package Anagram;

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
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
    // Write your code here
        int l = s.length();
        int result = 0;
        if(l % 2 != 0) return -1;
        String s1 = s.substring(0, l/2);
        String s2 = s.substring(l/2, l);
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        List<Character> chars1 = new ArrayList<Character>();
        List<Character> chars2 = new ArrayList<Character>();
        for(int i=0; i<l/2; i++) {
            chars1.add(s1.charAt(i));
            chars2.add(s2.charAt(i));
        }
        char temp = '0';
        for(int i=0; i<l/2; i++) {
            temp = chars1.get(i);
            if(chars2.contains(temp)) {
                chars2.remove(chars2.indexOf(temp));
            }
        }
        result = chars2.size();
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.anagram(s);

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

