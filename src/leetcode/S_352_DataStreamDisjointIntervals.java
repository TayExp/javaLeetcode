package leetcode;

import java.util.Map.Entry;
import java.util.TreeMap;

public class S_352_DataStreamDisjointIntervals {
    TreeMap<Integer,Integer> treemap;
    /** Initialize your data structure here. */
    public S_352_DataStreamDisjointIntervals() {
    	treemap = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if(treemap.containsKey(val)) return;
        // Returns the greatest key strictly less than the given key
        // or null if there is no such key.
        Integer lo = treemap.lowerKey(val);
        Integer hi = treemap.higherKey(val);
        if(lo != null && hi != null && treemap.get(lo) + 1 == val && val+1 == hi) {
        	treemap.put(lo,treemap.get(hi));
        	treemap.remove(hi);
        } else if(lo != null && treemap.get(lo) + 1 >= val) {
            if(treemap.get(lo) + 1 == val )
        	    treemap.put(lo, val);
        } else if(hi != null && hi == val+1) {
        	treemap.put(val, treemap.get(hi));
        	treemap.remove(hi);
        } else {
        	treemap.put(val, val);
        }
    }
    
    public int[][] getIntervals() {
    	int [][] ret = new int[treemap.size()][2];
    	int i = 0;
    	for(Entry<Integer, Integer> entry : treemap.entrySet()) {
    		ret[i][0] = entry.getKey();
    		ret[i++][1] = entry.getValue();
    	}
        return ret;
    }
}
