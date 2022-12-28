import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        MyEditor me = new MyEditor("");
        int total = sc.nextInt();
        ArrayList<String> moves = new ArrayList<String>();
        for(int i=0; i<total; i++) {
            int action = sc.nextInt();            
            if(action == 1) {
                moves.add(me.str);
                String app = sc.next();
                me.append(app);
            } else if(action == 2) {
                moves.add(me.str);
                int num = sc.nextInt();
                me.delete(num);
            } else if(action == 3) {
                int num = sc.nextInt();  
                me.print(num);
            } else {
                int numMoves = moves.size();
                String undoStr = moves.get(numMoves-1);
                me.str = undoStr;
                moves.remove(numMoves-1);
            }
        }
        sc.close();
    }
}

class MyEditor {
    String str = "";
    
    MyEditor(String s) {
        str = s;
    }
    
    void append(String a) {
        str += a;
    }
    
    void delete(int k) {
        int l = str.length();        
        str = str.substring(0, (l-k));
    }
    
    void print(int k) {
        System.out.println(str.charAt(k-1));
    }
}
