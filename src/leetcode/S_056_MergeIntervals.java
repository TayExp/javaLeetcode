package leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class S_056_MergeIntervals {
	public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	 }
	public List<Interval> merge(List<Interval> intervals) {
        LinkedList<Interval> ret = new LinkedList<>();
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
            }
        });
        for(Interval interval : intervals){
        	if( ret.isEmpty() || interval.start > ret.getLast().end )
        		ret.add(interval);
        	else{
        		ret.getLast().end = Math.max(ret.getLast().end, interval.end);
        	}
        }
        return ret;
    }
	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	LinkedList<Interval> ret = new LinkedList<>();
    	int i;
    	for(i = 0; i < intervals.size(); i++){
    		
    		if( newInterval.start <= intervals.get(i).start )
        		break;
    		ret.add(intervals.get(i));
    	}
    	if(ret.isEmpty() || ret.get(ret.size()-1).end < newInterval.start)
            ret.add(newInterval);
        else
            ret.get(ret.size()-1).end = Math.max(ret.get(ret.size()-1).end, newInterval.end);
    	for(; i<intervals.size(); i++){
    		if(ret.getLast().end < intervals.get(i).start){
    			ret.add(intervals.get(i));
    			break;
    		}
        	else{
        		ret.getLast().end = Math.max(ret.getLast().end, intervals.get(i).end);
        	}
        }
    	for(i = i+1; i< intervals.size();i++)
    		ret.add(intervals.get(i));
        return ret;
    }
}
