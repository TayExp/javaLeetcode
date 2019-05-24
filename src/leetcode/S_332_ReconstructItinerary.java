package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class S_332_ReconstructItinerary {
	
    public List<String> findItinerary(List<List<String>> tickets) {
    	Map<String, List<String>> map = new HashMap<>();
    	List<String> l;
        for(int i = 0; i < tickets.size();i++) {
        	l = tickets.get(i);
        	List<String> strings = map.getOrDefault(l.get(0), new LinkedList<>());
        	int insertion = 0;
        	for(; insertion < strings.size(); insertion++) {
        		if(!greater(l.get(1), strings.get(insertion)))
        			break;
        	}
        	strings.add(insertion, l.get(1));
        	map.put(l.get(0), strings);
        }
        LinkedList<String> ret = new LinkedList<>();
//        String start = "JFK";
//        ret.add(start);
//        while(!map.isEmpty()) {
//        	ret.add(map.get(start).remove(0));;
//        	if(map.get(start).size() == 0) map.remove(start);
//        	start = ret.getLast();
//        }
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while(!stack.isEmpty()) {
        	while(map.containsKey(stack.peek()) && map.get(stack.peek()).size() != 0)
        		stack.push(map.get(stack.peek()).remove(0));
        	ret.add(0,stack.pop());
        }
        return ret;
    }
    
    private boolean greater(String s1, String s2) {
    	for(int i = 0 ; i < 3; i++)
    		if(s1.charAt(i) > s2.charAt(i)) return true;
    		else if(s1.charAt(i) < s2.charAt(i)) return false;
    	return false;
    }
    
    public static void main(String[] args) {
		List<List<String>> tickets = new ArrayList<>();
		List<String> l = new ArrayList<>();
		l.add("MUC");
		l.add("LHR");
		tickets.add(l);
		List<String> l1 = new ArrayList<>();
		l1.add("JFK");
		l1.add("MUC");
		tickets.add(l1);
		List<String> l2 = new ArrayList<>();
		l2.add("SFO");
		l2.add("SJC");
		tickets.add(l2);
		List<String> l3 = new ArrayList<>();
		l3.add("LHR");
		l3.add("SFO");
		tickets.add(l3);
		System.out.println(new S_332_ReconstructItinerary().findItinerary(tickets ));
	}
}
