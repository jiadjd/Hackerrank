package SimpleTextEditor;

import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner sc = new Scanner(System.in);
            String s = "";
            int q = sc.nextInt();
            Stack<String> actions = new Stack<>();
            int i = 0;
            while (i<q) {
                int operation = sc.nextInt();
                if(operation == 1) {
                    actions.push(s);                    
                    String append = sc.next();
                    s += append;
                } else if(operation == 2) {
                    actions.push(s);                    
                    int del = sc.nextInt();
                    s = s.substring(0, s.length()-del);
                } else if(operation == 3) {
                    int k = sc.nextInt();
                    System.out.println(s.charAt(k-1));
                } else {
                    s = actions.pop();
                }
                i++;
            }
            sc.close();
    }
}