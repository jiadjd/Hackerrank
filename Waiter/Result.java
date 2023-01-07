package Waiter;

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
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY number
     *  2. INTEGER q
     */

    public static List<Integer> waiter(List<Integer> number, int q) {
    // Write your code here
        List<Integer> answer = new ArrayList<Integer>();
        List<Integer> primeNumbers = primes(q);
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();
        List<Integer> listC = new ArrayList<Integer>();
        for(int n: number) {
            stackA.push(n);
        }
        for(int i=0; i<q; i++) {
            while(!stackA.isEmpty()) {
                int num = stackA.pop();
                if(num%primeNumbers.get(i) == 0) {
                    stackB.push(num);
                } else {
                    listC.add(num);
                }
            }
            while(!stackB.isEmpty()) {
                answer.add(stackB.pop());
            }
            if(!listC.isEmpty()) {
                for(int j=0; j<listC.size(); j++) {
                    stackA.push(listC.get(j));
                }
                listC.clear();
            }
        }
        while(!stackA.isEmpty()) {
            answer.add(stackA.pop());
        }
        return answer;
    }
    
    private static List<Integer> primes(int q) {
        List<Integer> primeNumbers = new ArrayList<Integer>();
        primeNumbers.add(2);
        int num = 3;
        boolean prime = true;
        while (primeNumbers.size() < q) {
            for(int i=2; i<=num/2; i++) {
                if(num%i == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) primeNumbers.add(num);
            num += 2;
            prime = true;
        }
        return primeNumbers;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.waiter(number, q);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
