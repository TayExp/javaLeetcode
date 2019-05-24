package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class S_218_SkyLine {
    public List<int[]> getSkyline(int[][] buildings) {
    	List<int[]> ret = new ArrayList<>(); 
    	List<int[]> height = new ArrayList<>(); 
    	for(int[] b:buildings) { 
    		height.add(new int[]{b[0], -b[2]}); 
    		height.add(new int[]{b[1], b[2]}); 
    	} 
    	Collections.sort(height, (a, b) ->
    		{ if(a[0] != b[0]) return a[0] - b[0]; return a[1] - b[1]; });
    	Queue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
    	pq.offer(0);
    	int prev = 0;
    	for(int[] h: height) {
    		if(h[1] < 0)
    			pq.offer(-h[1]);
    		else
    			pq.remove(h[1]);
    		int cur = pq.peek();
    		if(prev != cur) {
    			ret.add(new int[] {h[0],cur});
    			prev = cur;
    		}
    		
    	}
    	return ret;
    
    }
	
    public static void main(String[] args) {
		System.out.println(new S_218_SkyLine().getSkyline(new int[][] {{2, 9, 10}, {3, 7, 15}, {5, 12, 12},{15, 20, 10}, {19, 24, 8}}));
	}
}
