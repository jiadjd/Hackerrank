package BreadthFirstSearchShortestReach;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		int n = 5;
		int m = 3;
		int s = 1;
		List<List<Integer>> edges = new ArrayList<>();
		
		List<Integer> e1 = new ArrayList<>();
		e1.add(1);
		e1.add(2);
		edges.add(e1);
		
		List<Integer> e2 = new ArrayList<>();
		e2.add(1);
		e2.add(3);
		edges.add(e2);
		
		List<Integer> e3 = new ArrayList<>();
		e3.add(3);
		e3.add(4);
		edges.add(e3);
		
		
		
		List<Integer> distances = Solution.bfs(n, m, edges, s);
		
		System.out.println(distances);
		
	}

}
