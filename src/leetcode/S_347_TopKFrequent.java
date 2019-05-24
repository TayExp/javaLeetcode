package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class S_347_TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> (count.get(b)-count.get(a)));
        for(int n : nums){
            count.put(n, count.getOrDefault(n,0)+1);
        }
        List<Integer> ret = new LinkedList<>();
        while(ret.size() < k){
            ret.add(pq.poll());
        }
        return ret;
    }
    public static void main(String[] args) {
		System.out.println(new S_347_TopKFrequent().topKFrequent(new int[] {1,1,1,2,2,3}, 2));
	}
}
