package NoPrefixSet;

import java.util.*;

public class Main {

	public static void noPrefix(List<String> words) {
        TreeSet<String> treeSet = new TreeSet<>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            String next = treeSet.ceiling(word);
            String prev = treeSet.floor(word);
            
            if ((next != null && next.startsWith(word)) || (prev != null && word.startsWith(prev))) {
                System.out.println("BAD SET");
                System.out.println(word);
                return;
            }
            
            treeSet.add(word);
        }
        
        System.out.println("GOOD SET");
    }
}
