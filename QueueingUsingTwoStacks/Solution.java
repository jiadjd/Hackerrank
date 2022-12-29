package QueueingUsingTwoStacks;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        
        int q = sc.nextInt();
        for(int i=0; i<q; i++) {
            int query = sc.nextInt();
            if(query == 1) {
                int num = sc.nextInt();
                stack1.push(num);
            } else if(query == 2) {
                if(stack2.isEmpty()) {
                    while(!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                }
                stack2.pop();
            } else {
                if(stack2.isEmpty()) {
                    while(!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                }
                System.out.println(stack2.peek());
            }
        }
        
        sc.close();
    }
}
