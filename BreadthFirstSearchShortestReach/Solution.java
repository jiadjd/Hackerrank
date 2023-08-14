package BreadthFirstSearchShortestReach;
import java.util.*;

class Solution {
	
	public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
		List<Integer> distances = new ArrayList<>();
		List<List<Integer>> graph = new ArrayList<>();
		
		System.out.println("n: " + n);
        System.out.println("m: " + m);
        System.out.println("s: " + s);
        System.out.println(edges);
        
        //make graph with empty lists
        for(int i = 0; i < n; i++) {
        	graph.add(new ArrayList<Integer>());
        }
		
        //fill up the graph with edges
        for(int i = 0; i < m; i++) {
        	int src = edges.get(i).get(0) - 1;
        	int dst = edges.get(i).get(1) - 1;
        	
        	List<Integer> tempList = graph.get(src);
        	if(!tempList.contains(dst)) {
        		tempList.add(dst);
        		graph.remove(src);
        		graph.add(src, tempList);
        	}
        	
        	tempList = graph.get(dst);
        	if(!tempList.contains(src)) {
        		tempList.add(src);
        		graph.remove(dst);
        		graph.add(dst, tempList);
        	}
        }
        
        System.out.println(graph);
        
        int[] d = new int[n];
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[s-1] = true;
        queue.offer(s-1);
        
        while(!queue.isEmpty()) {
        	int q = queue.poll();
        	
        	for(int num : graph.get(q)) {
        		if(!visited[num]) {
        			visited[num] = true;
        			queue.offer(num);
        			d[num] = d[q] + 6;
        		}
        	}
        }
        
        for(int num : d) System.out.print(num + ", ");
        System.out.println();
        
        for(int i = 0; i < n; i++) {
        	if(i != s - 1) {
        		if(d[i] == 0) distances.add(-1);
        		else distances.add(d[i]);
        	}
        }
        
		return distances;
	}

}
