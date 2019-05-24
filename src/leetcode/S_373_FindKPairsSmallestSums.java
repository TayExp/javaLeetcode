package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import bGeneric.Pair;

public class S_373_FindKPairsSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0) return ret;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]+a[1]-b[0]-b[1]));
        for(int i = 0; i < nums1.length && i < k; i++) 
        	pq.add(new int[] {nums1[i], nums2[0], 0}); //初始堆, n1, n2， index2
        while(k-- > 0 && !pq.isEmpty()) {
        	int[] cur = pq.poll();
        	ret.add(new int[] {cur[0], cur[1]});
        	if(cur[2] == nums2.length-1) continue;
        	pq.add(new int[] {cur[0], nums2[cur[2]+1], cur[2]+1});
        }
        return ret;
    }
}
